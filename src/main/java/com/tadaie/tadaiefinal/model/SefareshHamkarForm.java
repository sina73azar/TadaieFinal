package com.tadaie.tadaiefinal.model;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;

import com.dlsc.formsfx.model.structure.Section;
import com.dlsc.formsfx.view.controls.SimpleRadioButtonControl;
import com.dlsc.formsfx.view.util.ColSpan;

public class SefareshHamkarForm {
    private final SefareshHamkar sefareshHamkar = new SefareshHamkar();
    private Form form;

    public Form getFormInstance(){
        if (form == null) {
            createForm();
        }
        return form;
    }

    private void createForm() {
        sefareshHamkar.initializeAllHamkars();
        form=Form.of(
                getDesignSection()
                ,
                //regular information
                Section.of(
                        Field.ofStringType(sefareshHamkar.nameProperty())
                                .label("نام سفارش")
                                .styleClass("allFields")
                                .span(ColSpan.HALF)

                        ,
                        Field.ofSingleSelectionType(sefareshHamkar.allHamkarsProperty(), sefareshHamkar.hamkarNameProperty())
                                .label("انتخاب همکار")
                                .required("ثبت سفارش بدون انتخاب همکار امکان پذیر نیست")
                                .tooltip("اگر همکار مربوطه در لیست نیست ابتدا در قسمت همکاران آن را ثبت کنید")
                                .styleClass("allFields")
                                .span(ColSpan.HALF)
                ).title("اطلاعات کلی")
                ,
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
                Field.ofBooleanType(sefareshHamkar.getDesign().graphicDesignProperty())
                        .label("طرح گرافیکی")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "designLabels", "graphicText")
                ,
                Field.ofBooleanType(sefareshHamkar.getDesign().editProperty())
                        .label("ادیت")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "designLabels")
                ,
                Field.ofBooleanType(sefareshHamkar.getDesign().reformatProperty())
                        .label("فرم چینی")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "designLabels")
                ,
                Field.ofStringType(sefareshHamkar.getDesign().detailsProperty())
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
                Field.ofSingleSelectionType(sefareshHamkar.getPrint().machineSizesProperty(), sefareshHamkar.getPrint().machineSizeProperty())
                        .label("نوع دستگاه")
                        .styleClass("allFields", "firstRowFields")
                        .span(ColSpan.HALF)
                ,
                Field.ofSingleSelectionType(sefareshHamkar.getPrint().machineModelsProperty(),sefareshHamkar.getPrint().machineModelProperty())
                        .styleClass("allFields", "firstRowFields")
                        .label("مدل دستگاه")
                        .span(ColSpan.HALF)
                ,
                Field.ofIntegerType(sefareshHamkar.getPrint().tirazhProperty())
                        .id("tirazhField")
                        .label("محاسبه تیراژ :")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
        ).title("چاپ");
    }

    private Section getPaperSection() {
        return Section.of(
                Field.ofSingleSelectionType(sefareshHamkar.getPaper().paperTypesProperty(), sefareshHamkar.getPaper().paperTypeProperty())
                        .id("paperType")
                        .styleClass("allFields", "firstRowFields")
                        .render(new SimpleRadioButtonControl<>())
                        .span(ColSpan.HALF)

                ,
                Field.ofSingleSelectionType(sefareshHamkar.getPaper().materialsProperty(), sefareshHamkar.getPaper().materialProperty())
                        .label("جنس")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
                ,
                Field.ofDoubleType(sefareshHamkar.getPaper().massProperty())
                        .label("گرم")
                        .tooltip("وزن کاغذ")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
                ,
                Field.ofStringType(sefareshHamkar.getPaper().brandProperty())
                        .label("برند")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
                ,
                Field.ofDoubleType(sefareshHamkar.getPaper().widthProperty())
                        .id("paperWidth")
                        .tooltip("طول")
                        .span(ColSpan.QUARTER)
                        .label("ابعاد ورق")
                        .styleClass("allFields", "firstRowFields", "dimensions")

                ,
                Field.ofDoubleType(sefareshHamkar.getPaper().widthProperty())
                        .id("paperHeight")
                        .tooltip("عرض")
                        .span(ColSpan.QUARTER)
                        .label(null)
                        .styleClass("allFields", "firstRowFields", "dimensions")

                ,
                Field.ofIntegerType(sefareshHamkar.paperCountProperty())
                        .id("fieldCountVaragh")
                        .label("تعداد ورق")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firstRowFields")
                ,
                Field.ofDoubleType(sefareshHamkar.getPaper().widthSheetProperty())
                        .id("paperWidth")
                        .tooltip("طول شیت")
                        .span(ColSpan.QUARTER)
                        .label("سایز شیت")
                        .styleClass("allFields", "firstRowFields", "dimensions")

                ,
                Field.ofDoubleType(sefareshHamkar.getPaper().heightSheetProperty())
                        .id("paperHeight")
                        .tooltip("عرض شیت")
                        .span(ColSpan.QUARTER)
                        .label(null)
                        .styleClass("allFields", "firstRowFields", "dimensions")

                ,
                Field.ofIntegerType(sefareshHamkar.getPaper().numeratorFractionProperty())
                        .styleClass("allFields", "firstRowFields", "dimensions")
                        .label("صورت")

                ,
                Field.ofIntegerType(sefareshHamkar.getPaper().denominatorFractionProperty())
                        .styleClass("allFields", "firstRowFields", "dimensions")
                        .label("مخرج")


        ).title("کاغذ");
    }

    private Section getLitoSection() {
        return Section.of(
                Field.ofBooleanType(sefareshHamkar.getLito().haveMasrafiProperty())
                        .label("مصرفی")
                        .styleClass("allFields", "boolCheck", "firsRowFields")
                        .span(ColSpan.QUARTER)
                ,
                Field.ofIntegerType(sefareshHamkar.getLito().masrafiCountProperty())
                        .label("تعداد")
                        .tooltip("تعداد زینک مصرفی")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "firsRowFields")

                ,
                Field.ofBooleanType(sefareshHamkar.getLito().haveErsaliProperty())
                        .label("ارسالی")
                        .styleClass("allFields", "boolCheck", "firsRowFields")
                        .span(ColSpan.QUARTER)
                ,
                Field.ofIntegerType(sefareshHamkar.getLito().ersaliCountProperty())
                        .label("تعداد")
                        .tooltip("تعداد زینک ارسالی")
                        .span(ColSpan.QUARTER)
                        .styleClass("allFields", "firsRowFields")

                ,
                Field.ofSingleSelectionType(sefareshHamkar.getLito().machineSizesProperty(), sefareshHamkar.getLito().machineSizeProperty())
                        .label("سایز")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firsRowFields")
                ,
                Field.ofSingleSelectionType(sefareshHamkar.getLito().machineModelsProperty(), sefareshHamkar.getLito().machineModelProperty())
                        .label("مدل دستگاه")
                        .span(ColSpan.HALF)
                        .styleClass("allFields", "firsRowFields")
                ,
                Field.ofMultiSelectionType(sefareshHamkar.getLito().colorsListProperty(), sefareshHamkar.getLito().colorSelectedProperty())
                        .label("رنگ")
                        .styleClass("allFields", "firsRowFields", "multiListField")
                        .span(ColSpan.HALF)
                ,
                Field.ofSingleSelectionType(sefareshHamkar.getLito().filmMachinesProperty(), sefareshHamkar.getLito().filmMachineProperty())
                        .label("فیلم")
                        .styleClass("allFields", "firstRowFields")
                        .span(ColSpan.HALF)
                ,
                //details Lito
                Field.ofStringType(sefareshHamkar.getLito().detailsProperty())
                        .label("توضیحات")
                        .multiline(true)
                        .styleClass("allFields", "firsRowFields", "detailsFields")

        ).title("لیتوگرافی");
    }
}
