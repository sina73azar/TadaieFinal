package com.tadaie.tadaiefinal.model;

import com.tadaie.tadaiefinal.database.MySqlCon;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.List;


public class SefareshClient {
    private int id;
    private StringProperty name = new SimpleStringProperty("");
    private ListProperty<String> allClients;
    private ObjectProperty<String> clientName = new SimpleObjectProperty<>("...");
    //lito field
    private Lito lito;

    //paper fields
    private Paper paper;
    private IntegerProperty paperCount = new SimpleIntegerProperty();

    //design
    private Design design;

    //print
    private Print print;

    public Print getPrint() {
        return print;
    }

    public Design getDesign() {
        return design;
    }

    public int getPaperCount() {
        return paperCount.get();
    }

    public IntegerProperty paperCountProperty() {
        return paperCount;
    }


    public SefareshClient() {
        this.paper = new Paper();
        this.lito = new Lito();
        this.design = new Design();
        this.print = new Print();
    }


    public void initializeAllClient() {
        allClients = new SimpleListProperty<>(FXCollections.observableArrayList(getAllClientsNames()));
    }

    public Paper getPaper() {
        return paper;
    }

    public Lito getLito() {
        return lito;
    }

    private List<String> getAllClientsNames() {
        List<String> names = new ArrayList<>();
        MySqlCon db = MySqlCon.getInstance();
        db.getAllClients().forEach(clientT -> names.add(clientT.getName()));
        return names;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }


    public ListProperty<String> allClientsProperty() {
        return allClients;
    }

    public String getClientName() {
        return clientName.get();
    }

    public ObjectProperty<String> clientNameProperty() {
        return clientName;
    }




}
