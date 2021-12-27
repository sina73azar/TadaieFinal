package com.tadaie.tadaiefinal.model;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.model.validators.StringLengthValidator;
import com.dlsc.formsfx.view.controls.SimpleTextControl;

public class HamkarFormModel {
    private final Hamkar hamkar = new Hamkar();
    private Form formInstance;

    public Form getFormInstance() {
        if (formInstance == null) {
            createForm();
        }

        return formInstance;
    }
    private void createForm() {

        formInstance = Form.of(
                Group.of(
                        Field.ofStringType(hamkar.nameProperty())
                                .label("نام")
                                .placeholder("برای مثال : محمد رمضانی")
                                .required("مشتری بدون نام امکان ثبت نداره")
                                .validate(StringLengthValidator.atLeast(3, "حداقل باید 3 حرف باشه"))
                        ,
                        Field.ofStringType(hamkar.phoneProperty())
                                .label("شماره تماس")
                                .id("phone1")
                                .styleClass("phoneField")
                        ,

                        Field.ofStringType(hamkar.addressProperty())
                                .label("آدرس")
                        ,
                        Field.ofStringType(hamkar.detailsProperty())
                                .label("توضیحات")
                                .render(new SimpleTextControl())
                                .multiline(true)
                )

        ).title("فرم ثبت همکار");

    }
    public Hamkar getHamkar() {
        return hamkar;
    }
}
