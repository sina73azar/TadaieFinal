package com.tadaie.tadaiefinal.panes;


import com.jfoenix.controls.JFXButton;
import com.tadaie.tadaiefinal.database.MySqlCon;

import com.tadaie.tadaiefinal.model.Hamkar;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.List;

public class HamkaranListPane {
    public JFXButton deleteHamkar;
    public Label lblMesage;
    private List<Hamkar> hamkaranList;
    @FXML
    private TableView<Hamkar> tableHamkaran;
    @FXML
    private TableColumn<Hamkar, Integer> idCol;
    @FXML
    private TableColumn<Hamkar, String> nameCol;
    @FXML
    private TableColumn<Hamkar, String> phoneCol;
    @FXML
    private TableColumn<Hamkar, String> addressCol;
    @FXML
    private TableColumn<Hamkar, String> detailsCol;

    ObservableList<Hamkar> hamkaranObservable = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        loadHamkarTable();
        handleEvents();

    }

    private void loadHamkarTable() {

        hamkaranList = MySqlCon.getInstance().getAllHamkaran();
        tableHamkaran.setEditable(true);
        hamkaranObservable.addAll(hamkaranList);

        idCol.setCellValueFactory(new PropertyValueFactory<Hamkar, Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Hamkar, String>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneCol.setCellValueFactory(new PropertyValueFactory<Hamkar, String>("phone"));
        phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());

        addressCol.setCellValueFactory(new PropertyValueFactory<Hamkar, String>("address"));
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        detailsCol.setCellValueFactory(new PropertyValueFactory<Hamkar, String>("details"));
        detailsCol.setCellFactory(TextFieldTableCell.forTableColumn());

        nameCol.setOnEditCommit(hamkarStringCellEditEvent -> {
            MySqlCon.getInstance().updateHamkarName(hamkarStringCellEditEvent.getRowValue().getId(), hamkarStringCellEditEvent.getNewValue());
        });
        phoneCol.setOnEditCommit(hamkarStringCellEditEvent -> {
            MySqlCon.getInstance().updatePhoneHamkarFromId(
                    hamkarStringCellEditEvent.getRowValue().getId()
                    , hamkarStringCellEditEvent.getNewValue());
        });
        addressCol.setOnEditCommit(hamkarStringCellEditEvent ->
                MySqlCon.getInstance().updateAddressHamkarFromId(hamkarStringCellEditEvent.getRowValue().getId(), hamkarStringCellEditEvent.getNewValue()));
        detailsCol.setOnEditCommit(hamkarStringCellEditEvent -> MySqlCon.getInstance().updateDetailsHamkarFromId(hamkarStringCellEditEvent.getRowValue().getId(), hamkarStringCellEditEvent.getNewValue()));
        tableHamkaran.setItems(hamkaranObservable);

    }

    private void handleEvents() {
        deleteHamkar.setOnAction(event -> {
            Hamkar selectedHamkar = tableHamkaran.getSelectionModel().getSelectedItem();
            if (selectedHamkar == null) {
                System.out.println("no Hamkar is selected");
                lblMesage.setText("هیچ همکاری برای حذف انتخاب نشده است");
            } else {
                System.out.println("deleting hamkar : " + selectedHamkar.getName());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("واقعا پاک کنم؟");
                alert.setTitle("حذف همکار");
                alert.setHeaderText("همکار انتخاب شده : " + selectedHamkar.getName());

                alert.showAndWait();
                if (alert.getResult() == ButtonType.CANCEL) {
                    System.out.println("cancel deleting");
                } else if (alert.getResult() == ButtonType.OK) {
                    System.out.println("go for deleting");

                    boolean deleted = MySqlCon.getInstance().deleteHamkar(selectedHamkar.getId());

                    if (deleted) {
                        System.out.println("succesfully deleted");
                        hamkaranObservable.removeAll(selectedHamkar);
                        lblMesage.setText("همکار حذف شد");
                    } else {
                        System.out.println("failed to delete");
                        lblMesage.setText("حذف همکار با مشکل مواجه شد ممکن است از این همکار سفارش ثبت شده باشد");
                    }


                }
            }

        });

    }
}
