package com.tadaie.tadaiefinal.model;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;

import com.dlsc.formsfx.model.validators.StringLengthValidator;
import com.dlsc.formsfx.view.controls.SimpleTextControl;


public final class ClientFormModel {

    private final ClientT client = new ClientT();

//    /**
//     * These are the resource bundles for german and english.
//     */
//    private ResourceBundle rbDE = ResourceBundle.getBundle("demo-locale", new Locale("de", "CH"));
//    private ResourceBundle rbEN = ResourceBundle.getBundle("demo-locale", new Locale("fa", "IR"));


    /**
     * The default locale is English, thus the {@code ResourceBundleService} is
     * initialised with it.
     */
//    private ResourceBundleService rbs = new ResourceBundleService(rbEN);

    private Form formInstance;

    /**
     * Creates or simply returns to form singleton instance.
     *
     * @return Returns the form instance.
     */
    public Form getFormInstance() {
        if (formInstance == null) {
            createForm();
        }
        return formInstance;
    }
    /**
     * Creates a new form instance with the required information.
     */
    private void createForm() {

        formInstance = Form.of(
                Group.of(
                        Field.ofStringType(client.nameProperty())
                                .label("نام")
                                .placeholder("برای مثال : محمد رمضانی")
                                .required("مشتری بدون نام امکان ثبت نداره")
                                .validate(StringLengthValidator.atLeast(3, "حداقل باید 3 حرف باشه"))
                                ,
                        Field.ofStringType(client.phoneProperty())
                                .label("شماره تماس")
                                .id("phone1")
                                .styleClass("phoneField")
                                ,
                        Field.ofStringType(client.companyProperty())
                                .label("شرکت")
                                ,
                        Field.ofStringType(client.addressProperty())
                                .label("آدرس")
                                ,
                        Field.ofStringType(client.detailsProperty())
                                .label("توضیحات")
                                .render(new SimpleTextControl())
                                .multiline(true)
                )

        ).title("فرم ثبت مشتری")
        ;

    }

//    /**
//     * Sets the locale of the form.
//     *
//     * @param language The language identifier for the new locale. Either DE or EN.
//     */
//    public void translate(String language) {
//        switch (language) {
//            case "EN":
//                rbs.changeLocale(rbEN);
//                break;
//            case "DE":
//                rbs.changeLocale(rbDE);
//                break;
//            default:
//                throw new IllegalArgumentException("Not a valid locale");
//        }
//    }

    public ClientT getClient() {
        return client;
    }

}