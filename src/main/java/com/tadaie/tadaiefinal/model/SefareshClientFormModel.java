package com.tadaie.tadaiefinal.model;


import com.dlsc.formsfx.model.structure.*;
import com.dlsc.formsfx.view.controls.*;
import com.dlsc.formsfx.view.util.ColSpan;


public class SefareshClientFormModel {
    private final SefareshClient sefaresh = new SefareshClient();
    private Form form;


    public Form getFormInstance() {
        if (form == null) {
            createForm();
        }

        return form;
    }

    private void createForm() {
        sefaresh.initializeAllClient();
        form = Form.of(
                getDesignSection()
                ,
                //regular information
                Section.of(
                        Field.ofStringType(sefaresh.nameProperty())
                                .label("نام سفارش")
                                .styleClass("allFields")
                                .span(ColSpan.HALF)

                        ,
                        Field.ofSingleSelectionType(sefaresh.allClientsProperty(), sefaresh.clientNameProperty())
                                .label("انتخاب مشتری")
                                .required("ثبت سفارش بدون انتخاب مشتری امکان پذیر نیست")
                                .tooltip("اگر مشتری مربوطه در لیست نیست ابتدا در قسمت مشتریان آن را ثبت کنید")
                                .styleClass("allFields")
                                .span(ColSpan.HALF)
                ).title("اطلاعات کلی")
                ,
                //lito section
                getLitoSection()
                ,
                //paper section
                getPaperSection()
                ,
                getPrintSection()
                ,
                getMalakhiSection()
                ,
                getSahhafiSection()
        );
    }

    private Section getDesignSection() {
        return Section.of(
                Field.ofBooleanType(sefaresh.getDesign().graphicDesignProperty())
                        .label("طرح گرافیکی")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "designLabels", "graphicText")
                ,
                Field.ofBooleanType(sefaresh.getDesign().editProperty())
                        .label("ادیت")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "designLabels")
                ,
                Field.ofBooleanType(sefaresh.getDesign().reformatProperty())
                        .label("فرم چینی")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "designLabels")
                ,
                Field.ofStringType(sefaresh.getDesign().detailsProperty())
                        .label("توضیحات")
                        .multiline(true)
                        .styleClass("allFields", "detailsFields")
        ).title("طراحی");
    }

    private Section getSahhafiSection() {
        return Section.of(

        ).title("صحافی");
    }

    private Section getMalakhiSection() {
        return Section.of(

        ).title("ملخی");
    }

    private Section getPrintSection() {


        return Section.of(
                Field.ofSingleSelectionType(sefaresh.getPrint().machineSizesProperty(), sefaresh.getPrint().machineSizeProperty())
                        .label("نوع دستگاه")
                        .styleClass("allFields", "firstRowFields")
                        .span(ColSpan.HALF)
                ,
                Field.ofSingleSelectionType(sefaresh.getPrint().machineModelsProperty(),sefaresh.getPrint().machineModelProperty())
                        .styleClass("allFields", "firstRowFields")
                        .label("مدل دستگاه")
                        .span(ColSpan.HALF)
                ,
                Field.ofIntegerType(sefaresh.getPrint().tirazhProperty())
                        .id("tirazhField")
                        .label("محاسبه تیراژ :")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
                ).title("چاپ");
    }

    private Section getPaperSection() {
        return Section.of(
                Field.ofSingleSelectionType(sefaresh.getPaper().paperTypesProperty(), sefaresh.getPaper().paperTypeProperty())
                        .id("paperType")
                        .styleClass("allFields", "firstRowFields")
                        .render(new SimpleRadioButtonControl<>())
                        .span(ColSpan.HALF)

                ,
                Field.ofSingleSelectionType(sefaresh.getPaper().materialsProperty(), sefaresh.getPaper().materialProperty())
                        .label("جنس")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
                ,
                Field.ofDoubleType(sefaresh.getPaper().massProperty())
                        .label("گرم")
                        .tooltip("وزن کاغذ")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
                ,
                Field.ofStringType(sefaresh.getPaper().brandProperty())
                        .label("برند")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
                ,
                Field.ofDoubleType(sefaresh.getPaper().widthProperty())
                        .id("paperWidth")
                        .tooltip("طول")
                        .span(ColSpan.QUARTER)
                        .label("ابعاد ورق")
                        .styleClass("allFields", "firstRowFields", "dimensions")

                ,
                Field.ofDoubleType(sefaresh.getPaper().widthProperty())
                        .id("paperHeight")
                        .tooltip("عرض")
                        .span(ColSpan.QUARTER)
                        .label(null)
                        .styleClass("allFields", "firstRowFields", "dimensions")

                ,
                Field.ofIntegerType(sefaresh.paperCountProperty())
                        .id("fieldCountVaragh")
                        .label("تعداد ورق")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
                ,
                Field.ofDoubleType(sefaresh.getPaper().widthSheetProperty())
                        .id("paperWidth")
                        .tooltip("طول شیت")
                        .span(ColSpan.QUARTER)
                        .label("سایز شیت")
                        .styleClass("allFields", "firstRowFields", "dimensions")

                ,
                Field.ofDoubleType(sefaresh.getPaper().heightSheetProperty())
                        .id("paperHeight")
                        .tooltip("عرض شیت")
                        .span(ColSpan.QUARTER)
                        .label(null)
                        .styleClass("allFields", "firstRowFields", "dimensions")

                ,
                Field.ofIntegerType(sefaresh.getPaper().numeratorFractionProperty())
                        .styleClass("allFields", "firstRowFields", "dimensions")
                        .label("صورت")

                ,
                Field.ofIntegerType(sefaresh.getPaper().denominatorFractionProperty())
                        .styleClass("allFields", "firstRowFields", "dimensions")
                        .label("مخرج")


        ).title("کاغذ");
    }

    private Section getLitoSection() {
        return Section.of(
                Field.ofBooleanType(sefaresh.getLito().haveMasrafiProperty())
                        .label("مصرفی")
                        .styleClass("allFields", "boolCheck", "firsRowFields")
                        .span(ColSpan.QUARTER)
                ,
                Field.ofIntegerType(sefaresh.getLito().masrafiCountProperty())
                        .label("تعداد")
                        .tooltip("تعداد زینک مصرفی")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "firsRowFields")

                ,
                Field.ofBooleanType(sefaresh.getLito().haveErsaliProperty())
                        .label("ارسالی")
                        .styleClass("allFields", "boolCheck", "firsRowFields")
                        .span(ColSpan.QUARTER)
                ,
                Field.ofIntegerType(sefaresh.getLito().ersaliCountProperty())
                        .label("تعداد")
                        .tooltip("تعداد زینک ارسالی")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "firsRowFields")

                ,
                Field.ofSingleSelectionType(sefaresh.getLito().machineSizesProperty(), sefaresh.getLito().machineSizeProperty())
                        .label("سایز")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firsRowFields")
                ,
                Field.ofSingleSelectionType(sefaresh.getLito().machineModelsProperty(), sefaresh.getLito().machineModelProperty())
                        .label("مدل دستگاه")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firsRowFields")
                ,
                Field.ofMultiSelectionType(sefaresh.getLito().colorsListProperty(), sefaresh.getLito().colorSelectedProperty())
                        .label("رنگ")
                        .styleClass("allFields", "firsRowFields", "multiListField")
                        .span(ColSpan.HALF)
                ,
                Field.ofSingleSelectionType(sefaresh.getLito().filmMachinesProperty(), sefaresh.getLito().filmMachineProperty())
                        .label("فیلم")
                        .styleClass("allFields", "firstRowFields")
                        .span(ColSpan.HALF)
                ,
                //details Lito
                Field.ofStringType(sefaresh.getLito().detailsProperty())
                        .label("توضیحات")
                        .multiline(true)
                        .styleClass("allFields", "firsRowFields", "detailsFields")

        ).title("لیتوگرافی");
    }

    public SefareshClient getSefareshClient() {
        return sefaresh;
    }

}
