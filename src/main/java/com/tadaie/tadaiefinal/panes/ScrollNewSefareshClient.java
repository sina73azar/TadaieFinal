package com.tadaie.tadaiefinal.panes;

import com.dlsc.formsfx.view.renderer.FormRenderer;
import com.dlsc.formsfx.view.util.ViewMixin;
import com.tadaie.tadaiefinal.MainLauncher;
import com.tadaie.tadaiefinal.model.MyPersianDate;
import com.tadaie.tadaiefinal.model.SefareshClientFormModel;
import com.tadaie.tadaiefinal.utils.MyConstants;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import java.util.Objects;

public class ScrollNewSefareshClient extends ScrollPane implements ViewMixin {
    private SefareshClientFormModel model;
    private FormRenderer displayForm;
    private MyPersianDate persianDate;
    private Label customMessage;
    private HBox boxButtons;
    private Button submit;
    private Button reset;

    public ScrollNewSefareshClient(SefareshClientFormModel model) {
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
        displayForm.setSpacing(5);
        displayForm.setAlignment(Pos.TOP_CENTER);
        //layout box buttons
        boxButtons.setSpacing(15);
        boxButtons.setAlignment(Pos.CENTER);
        submit.setMinWidth(160.0);
        submit.setMinHeight(40.0);
        reset.setMinWidth(160.0);
        reset.setMinHeight(40.0);
        //add box persian dates to vbox form renderer
        displayForm.getChildren().add(0, persianDate.getDatePickerBox());
        displayForm.getChildren().addAll(boxButtons, customMessage);
        //set contents of scrollPane grow as scrollpane
        setFitToHeight(true);
        setFitToWidth(true);
        //it kinda messed up in orientation but this works with farsi ...lol
        displayForm.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        //fix alignment of fields
        customAlignment();
        //handle listeners
        //finally adding whole form renderer object which is a vBox to the scrollView
        setContent(displayForm);
    }

    private void customAlignment() {
        model.getFormInstance().getFields().forEach(field -> {

            String labelText = ((Label) field.getRenderer().getChildren().get(0)).getText();
            boolean requireChangeOrientation = (Objects.equals(labelText, MyConstants.MASRAFI))
                    ||
                    (Objects.equals(labelText, MyConstants.ERSALI))
                    ||
                    (Objects.equals(labelText, MyConstants.GRAPHIC_DESIGN))
                    ||
                    (Objects.equals(labelText, MyConstants.EDIT))
                    ||
                    (Objects.equals(labelText, MyConstants.COUNT))
                    ||
                    (Objects.equals(labelText, MyConstants.REFORMAT))
                    ||
                    (Objects.equals(field.getRenderer().getId(), "paperType"))

                    ;
            if (requireChangeOrientation) {
                field.getRenderer().getChildren().get(1).setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                return;
            }
            if ((Objects.equals(field.getRenderer().getId(), "paperHeight"))) {
                field.getRenderer().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                return;
            }
            if ((Objects.equals(field.getRenderer().getId(), "paperWidth"))) {
//                field.getRenderer().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
                field.getRenderer().setAlignment(Pos.CENTER);
                return;
            }
            if (Objects.equals(field.getRenderer().getId(), "fieldCountVaragh")){
                field.getRenderer().getChildren().get(1).setOnInputMethodTextChanged(inputMethodEvent -> {
                    System.out.println("count varagh changed : ");
                });


            }
            if (Objects.equals(field.getRenderer().getId(), "tirazhField")){
                field.getRenderer().getChildren().get(0).setOnMouseClicked(mouseEvent -> {
                    model.getSefareshClient().getPrint().tirazhProperty().setValue(computeTirazh());
                });
            }

            field.getRenderer().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            field.getRenderer().getChildren().get(0).setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            field.getRenderer().getChildren().get(1).setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        });
    }
    private int computeTirazh() {
        model.getFormInstance().persist();
        int tirazh = 0;
        int count = model.getSefareshClient().paperCountProperty().get();
        int numeratorFraction = model.getSefareshClient().getPaper().getNumeratorFraction();
        int denominatorFraction = model.getSefareshClient().getPaper().getDenominatorFraction();
        if (count == 0 || numeratorFraction == 0 || denominatorFraction == 0) {
            System.out.println("fill count and fractions");
        }else {
            tirazh = (count * denominatorFraction) / numeratorFraction;}
        return tirazh;
    }
    @Override
    public void setupEventHandlers() {
        submit.setOnAction(event -> submitAction());
        reset.setOnAction(event -> {
            model.getFormInstance().reset();
            persianDate.getStartDate().setValue(null);
            persianDate.getEndDate().setValue(null);

        });
        System.out.println("asasas"+model.getFormInstance().getFields().stream().count());

    }

    private void submitAction() {
        model.getFormInstance().persist();

        System.out.println("startDate: " + persianDate.getStartDate().valueProperty().get());
        System.out.println("name: " + model.getSefareshClient().getName());
        System.out.println("details: " + model.getSefareshClient().getLito().getDetails());
        System.out.println("material is: " + model.getSefareshClient().getPaper().getMaterial());
    }
}
