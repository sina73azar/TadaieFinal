package com.tadaie.tadaiefinal.panes;

import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.dlsc.formsfx.view.util.ViewMixin;
import com.tadaie.tadaiefinal.MainLauncher;
import com.tadaie.tadaiefinal.database.MySqlCon;
import com.tadaie.tadaiefinal.model.ClientFormModel;
import com.tadaie.tadaiefinal.model.HamkarFormModel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import java.util.Objects;

public class AnchorNewHamkar extends AnchorPane implements ViewMixin {
    private Label customMessage;
    private HBox boxButtons;
    private Button submit;
    private Button reset;
    private FormRenderer displayForm;
    private HamkarFormModel model;
    private boolean successFullySubmitted = false;

    //constructor
    public AnchorNewHamkar(HamkarFormModel model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeSelf() {
        getStylesheets().add(Objects.requireNonNull(MainLauncher.class.getResource("css/form_hamkar.css")).toExternalForm());
        getStyleClass().add("root_new_Hamkar_anchor");
    }

    @Override
    public void initializeParts() {
        submit = new Button("ثبت همکار");
        reset = new Button("خالی کردن فرم");
        customMessage = new Label();
        boxButtons = new HBox(submit, reset);

        displayForm = new FormRenderer(model.getFormInstance());
    }

    @Override
    public void layoutParts() {
        customMessage.setId("label_message");
        boxButtons.setSpacing(15);
        boxButtons.setAlignment(Pos.CENTER);
        submit.setId("submit");
        reset.setId("reset");
        submit.setMinWidth(160.0);
        submit.setMinHeight(40.0);
        reset.setMinWidth(160.0);
        reset.setMinHeight(40.0);
        AnchorPane.setTopAnchor(displayForm, 0.0);
        AnchorPane.setLeftAnchor(displayForm, 0.0);
        AnchorPane.setRightAnchor(displayForm, 0.0);
        AnchorPane.setBottomAnchor(displayForm, 0.0);
        displayForm.getChildren().addAll(boxButtons, customMessage);
        displayForm.setAlignment(Pos.TOP_CENTER);
        displayForm.setSpacing(15);
        getChildren().add(displayForm);
    }

    @Override
    public void setupEventHandlers() {
        submit.setOnAction(event -> submitForm());
        reset.setOnAction(event -> emptyAllForm());
    }
    private void emptyAllForm() {
        model.getHamkar().nameProperty().setValue("");
        model.getHamkar().phoneProperty().setValue("");
        model.getHamkar().addressProperty().setValue("");
        model.getHamkar().detailsProperty().setValue("");

    }
    private void submitForm() {

        model.getFormInstance().persist();
        if (model.getHamkar().getName().isBlank()) {
            customMessage.setStyle("-fx-text-fill:red");
            customMessage.setText("ثبت همکار بدون نام امکان پذیر نیست");
            return;
        }
        //insertion

        boolean successfullyInserted = MySqlCon.getInstance().insertHamkar(model.getHamkar());
        if (successfullyInserted) {
            customMessage.setText("ثبت همکار با موفقیت انجام شد و در لیست همکاران قابل مشاهده است");
            customMessage.setStyle("-fx-text-fill:green");

        }
        else {
            customMessage.setText("ثبت همکار با مشکلی مواجه شد");
        }

    }

    @Override
    public void setupValueChangedListeners() {
        ViewMixin.super.setupValueChangedListeners();
    }

    @Override
    public void setupBindings() {
        ViewMixin.super.setupBindings();
    }
}

