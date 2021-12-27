package com.tadaie.tadaiefinal.panes;

import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.dlsc.formsfx.view.util.ViewMixin;
import com.tadaie.tadaiefinal.MainLauncher;
import com.tadaie.tadaiefinal.database.MySqlCon;
import com.tadaie.tadaiefinal.model.ClientFormModel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.sql.SQLException;
import java.util.Objects;

public class AnchorNewClient extends AnchorPane implements ViewMixin {
    private Label customMessage;
    private HBox boxButtons;
    private Button submit;
    private Button reset;
    private FormRenderer displayForm;
    private final ClientFormModel model;


    //constructor
    public AnchorNewClient(ClientFormModel model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeSelf() {
        getStylesheets().add(Objects.requireNonNull(MainLauncher.class.getResource("css/form_client.css")).toExternalForm());
        getStyleClass().add("root_new_client_anchor");
    }

    @Override
    public void initializeParts() {
        submit = new Button("ثبت مشتری");
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
        submit.setMinWidth(160.0);
        submit.setMinHeight(40.0);
        reset.setId("reset");
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
        model.getClient().nameProperty().setValue("");
        model.getClient().phoneProperty().setValue("");
        model.getClient().companyProperty().setValue("");
        model.getClient().addressProperty().setValue("");
        model.getClient().detailsProperty().setValue("");

    }

    private void submitForm() {
        //persist
        model.getFormInstance().persist();
        //validate
        if (model.getClient().getName().isBlank()) {
            customMessage.setStyle("-fx-text-fill:red");
            customMessage.setText("ثبت مشتری بدون نام امکان پذیر نیست");
            return;
        }
        //insertion

        boolean successfullyInserted = MySqlCon.getInstance().insertClient(model.getClient());
        if (successfullyInserted) {
            customMessage.setText("ثبت مشتری با موفقیت انجام شد و در لیست مشتریان قابل مشاهده است");
            customMessage.setStyle("-fx-text-fill:green");

        }
        else {
            customMessage.setText("ثبت مشتری با مشکلی مواجه شد");
        }
    }

    @Override
    public void setupValueChangedListeners() {
        ViewMixin.super.setupValueChangedListeners();
    }


}
