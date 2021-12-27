package com.tadaie.tadaiefinal.panes;

import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.dlsc.formsfx.view.util.ViewMixin;
import com.tadaie.tadaiefinal.MainLauncher;
import com.tadaie.tadaiefinal.model.MyPersianDate;
import com.tadaie.tadaiefinal.model.SefareshHamkarForm;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

import java.util.Objects;

public class ScrollNewSefareshHamkar extends ScrollPane implements ViewMixin {
    private final SefareshHamkarForm model;
    private FormRenderer displayForm;
    private MyPersianDate persianDate;
    private Label customMessage;
    private HBox boxButtons;
    private Button submit;
    private Button reset;
    //constructor
    public ScrollNewSefareshHamkar(SefareshHamkarForm model){
        this.model = model;
        init();
    }
    @Override
    public void initializeSelf() {
        getStylesheets().add(Objects.requireNonNull(MainLauncher.class.getResource("css/FormSefareshClient")).toExternalForm());
        getStyleClass().add("root_new_Sefaresh_Client");
    }

    @Override
    public void initializeParts() {
        displayForm = new FormRenderer(model.getFormInstance());
        persianDate = new MyPersianDate();
        submit = new Button("ثبت سفارش");
        reset = new Button("خالی کردن فرم");
        customMessage = new Label();
        boxButtons = new HBox(submit, reset);
    }

    @Override
    public void layoutParts() {
        allignMentStuff();

        displayForm.getChildren().add(0, persianDate.getDatePickerBox());
        displayForm.getChildren().addAll(boxButtons, customMessage);
        setContent(displayForm);
    }

    private void allignMentStuff() {
        displayForm.setSpacing(5);
        displayForm.setAlignment(Pos.TOP_CENTER);
        //layout box buttons
        boxButtons.setSpacing(15);
        boxButtons.setAlignment(Pos.CENTER);
        submit.setMinWidth(160.0);
        submit.setMinHeight(40.0);
        reset.setMinWidth(160.0);
        reset.setMinHeight(40.0);
        setFitToHeight(true);
        setFitToWidth(true);
        displayForm.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        model.getFormInstance().getFields().forEach(field -> {
            if ((Objects.equals(field.getRenderer().getId(), "paperHeight"))) {
                field.getRenderer().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                return;
            }
            if ((Objects.equals(field.getRenderer().getId(), "paperWidth"))) {
//                field.getRenderer().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                field.getRenderer().setAlignment(Pos.CENTER);
                return;
            }

        });

        setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    }

    @Override
    public void setupEventHandlers() {
        ViewMixin.super.setupEventHandlers();
    }


}
