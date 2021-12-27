package com.tadaie.tadaiefinal.panes;

import com.jfoenix.controls.JFXButton;
import com.tadaie.tadaiefinal.database.MySqlCon;


import com.tadaie.tadaiefinal.model.ClientT;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


import java.util.List;

public class ClientListPane {
    @FXML
    public TableColumn<ClientT,Integer> idCol;
    public JFXButton deleteClient;
    public Label lblMesage;
    @FXML
    private TableColumn<ClientT,String> nameCol;
    @FXML
    public TableColumn<ClientT,String> phoneCol;
    @FXML
    public TableColumn<ClientT, String> addressCol;
    @FXML
    public TableColumn<ClientT, String> detailsCol;
    @FXML
    public TableColumn<ClientT, String> companyNameCol;

    private List<ClientT> clientsList;
    @FXML
    private TableView<ClientT> tableClients;
    ObservableList<ClientT> clientsObservable;
    @FXML
    public void initialize() {
        loadClientTable();
        handleEvents();
    }

    private void handleEvents() {
        //should be corrected with clientT model instead of Client
        deleteClient.setOnAction(event -> {
            ClientT selectedClient = tableClients.getSelectionModel().getSelectedItem();
            if (selectedClient == null) {
                System.out.println("no client is selected");
                lblMesage.setText("هیچ مشتری برای حذف انتخاب نشده است");
            } else {
                System.out.println("deleting hamkar : " + selectedClient.getName());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("واقعا پاک کنم؟");
                alert.setTitle("حذف مشتری");
                alert.setHeaderText("مشتری انتخاب شده : " + selectedClient.getName());

                alert.showAndWait();
                if (alert.getResult() == ButtonType.CANCEL) {
                    System.out.println("cancel deleting");
                } else if (alert.getResult()==ButtonType.OK) {
                    System.out.println("go for deleting");

                    boolean deleted = MySqlCon.getInstance().deleteClient(selectedClient.getId());

                    if (deleted) {
                        System.out.println("succesfully deleted");
                        clientsObservable.removeAll(selectedClient);
                        lblMesage.setText("مشتری حذف شد");
                    } else {
                        System.out.println("failed to delete");
                        lblMesage.setText("حذف مشتری با مشکل مواجه شد ممکن است از این مشتری سفارش ثبت شده باشد");

                    }


                }
            }
        });
    }

    private void loadClientTable() {
        tableClients.setEditable(true);

        clientsList=MySqlCon.getInstance().getAllClients();
        clientsObservable = FXCollections.observableArrayList();
        clientsObservable.addAll(clientsList);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        companyNameCol.setCellValueFactory(new PropertyValueFactory<>("company"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        detailsCol.setCellValueFactory(new PropertyValueFactory<>("details"));

        //in order to edit cells
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneCol.setCellFactory(TextFieldTableCell.forTableColumn());
        companyNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        addressCol.setCellFactory(TextFieldTableCell.forTableColumn());
        detailsCol.setCellFactory(TextFieldTableCell.forTableColumn());

        nameCol.setOnEditCommit(clientStringCellEditEvent -> MySqlCon.getInstance().updateClientNameFromId(clientStringCellEditEvent.getRowValue().getId(), clientStringCellEditEvent.getNewValue()));
        phoneCol.setOnEditCommit(clientStringCellEditEvent -> MySqlCon.getInstance().updateClientPhoneFromId(clientStringCellEditEvent.getRowValue().getId(), clientStringCellEditEvent.getNewValue()));
        companyNameCol.setOnEditCommit(clientStringCellEditEvent -> MySqlCon.getInstance().updateClientCompanyNameFromId(clientStringCellEditEvent.getRowValue().getId(), clientStringCellEditEvent.getNewValue()));
        addressCol.setOnEditCommit(clientStringCellEditEvent -> MySqlCon.getInstance().updateClientAddressFromId(clientStringCellEditEvent.getRowValue().getId(), clientStringCellEditEvent.getNewValue()));
        detailsCol.setOnEditCommit(clientStringCellEditEvent -> MySqlCon.getInstance().updateClientDetailsFromId(clientStringCellEditEvent.getRowValue().getId(), clientStringCellEditEvent.getNewValue()));
        tableClients.setItems(clientsObservable);

    }
}
