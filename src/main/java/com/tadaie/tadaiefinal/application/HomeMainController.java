package com.tadaie.tadaiefinal.application;

import com.tadaie.tadaiefinal.model.ClientFormModel;
import com.tadaie.tadaiefinal.model.HamkarFormModel;
import com.tadaie.tadaiefinal.model.SefareshClientFormModel;
import com.tadaie.tadaiefinal.model.SefareshHamkarForm;
import com.tadaie.tadaiefinal.panes.AnchorNewClient;
import com.tadaie.tadaiefinal.panes.AnchorNewHamkar;
import com.tadaie.tadaiefinal.panes.ScrollNewSefareshClient;
import com.tadaie.tadaiefinal.panes.ScrollNewSefareshHamkar;
import com.tadaie.tadaiefinal.utils.MyFxmlLoader;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeMainController implements Initializable {
    @FXML
    public Button btnClients;
    public Button btnHamkaran;
    public Button btnMojodi;
    public Button btnSefareshHamkar;
    public Button btnSefareshMoshtari;


    public MenuButton menuBtnClients;
    public MenuButton menuBtnHamkaran;
    public MenuItem itemListClients;
    public MenuItem itemNewClient;
    public MenuItem itemListHamkar;
    public MenuItem itemNewHamkar;
    public MenuButton menuBtnSefareshat;
    public MenuItem itemAddNewSefareshClient;
    public MenuItem itemAddNewSefareshHamkar;
    public MenuItem itemListSefareshClients;
    public MenuItem itemListSefareshHamkar;

    @FXML
    BorderPane borderPaneMain;
    MyFxmlLoader loader;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loader = new MyFxmlLoader();
        handleMenuItemsActions();
    }
    private void handleMenuItemsActions() {
        itemListClients.setOnAction(this::openListClient);
        itemNewClient.setOnAction(this::openAddNewClient);
        itemListHamkar.setOnAction(this::openHamkaranScene);
        itemNewHamkar.setOnAction(this::openAddNewHamkar);
        itemAddNewSefareshClient.setOnAction(this::openAddNewSefareshClient);
        itemAddNewSefareshHamkar.setOnAction(this::openAddNewSefareshHamkar);
        itemListSefareshClients.setOnAction(this::openDastoorkarClients);
        itemListSefareshHamkar.setOnAction(this::openDastoorKarHamkarScene);
    }
    //clients stuff
    public void openListClient(ActionEvent event){
        Pane view = loader.getPage("clientListPane");
        borderPaneMain.setCenter(view);
    }
    public void openAddNewClient(ActionEvent event) {
        ClientFormModel model = new ClientFormModel();
        AnchorNewClient anchorpane = new AnchorNewClient(model);
        borderPaneMain.setCenter(anchorpane);
    }
    //hamkaran stuff
    public void openHamkaranScene(ActionEvent event) {
        Pane view = loader.getPage("hamkaranListPane");
        borderPaneMain.setCenter(view);
    }
    public void openAddNewHamkar(ActionEvent keyEvent) {
        HamkarFormModel model = new HamkarFormModel();
        AnchorNewHamkar anchorNewHamkar = new AnchorNewHamkar(model);
        borderPaneMain.setCenter(anchorNewHamkar);
    }

    //sefareshat stuff

    public void openAddNewSefareshClient(ActionEvent keyEvent) {
        SefareshClientFormModel model = new SefareshClientFormModel();
        ScrollNewSefareshClient sefareshClient = new ScrollNewSefareshClient(model);
        borderPaneMain.setCenter(sefareshClient);
    }

    public void openAddNewSefareshHamkar(ActionEvent keyEvent) {
        SefareshHamkarForm model = new SefareshHamkarForm();
        ScrollNewSefareshHamkar sefareshHamkar = new ScrollNewSefareshHamkar(model);
        borderPaneMain.setCenter(sefareshHamkar);
    }
    public void openDastoorkarClients(ActionEvent event)  {
        Pane view = loader.getPage("list_dastoor_client");
        borderPaneMain.setCenter(view);
    }
    @FXML
    public void openDastoorKarHamkarScene(ActionEvent event)  {
        Pane view = loader.getPage("list_dastoor_hamkar");
        borderPaneMain.setCenter(view);
    }


}

