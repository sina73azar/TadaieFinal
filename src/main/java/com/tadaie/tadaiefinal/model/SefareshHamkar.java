package com.tadaie.tadaiefinal.model;

import com.tadaie.tadaiefinal.database.MySqlCon;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SefareshHamkar {
    //regular info
    private int id;
    private StringProperty name = new SimpleStringProperty("");
    private ListProperty<String> allHamkars;
    private ObjectProperty<String> hamkarName = new SimpleObjectProperty<>("...");

    //design
    private Design design;
    //lito
    private Lito lito;
    //paper
    private Paper paper;
    private IntegerProperty paperCount = new SimpleIntegerProperty();
    //print
    private Print print;

    //constructor

    public SefareshHamkar() {
        this.paper = new Paper();
        this.lito = new Lito();
        this.design = new Design();
        this.print = new Print();
    }

    public ObservableList<String> getAllHamkars() {
        return allHamkars.get();
    }

    public ListProperty<String> allHamkarsProperty() {
        return allHamkars;
    }

    public Design getDesign() {
        return design;
    }

    public Lito getLito() {
        return lito;
    }

    public Paper getPaper() {
        return paper;
    }

    public int getPaperCount() {
        return paperCount.get();
    }

    public IntegerProperty paperCountProperty() {
        return paperCount;
    }

    public Print getPrint() {
        return print;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public ObjectProperty<String> hamkarNameProperty(){
        return hamkarName;
    }
    public String getHamkarName(){
        return hamkarName.getName();
    }
    public void initializeAllHamkars(){
        allHamkars=new SimpleListProperty<>(FXCollections.observableArrayList(getAllHamkarNames()));
    }
    private List<String> getAllHamkarNames() {
        List<String> names = new ArrayList<>();
        MySqlCon db = MySqlCon.getInstance();
        db.getAllHamkaran().forEach(hamkar -> names.add(hamkar.getName()));
        return names;
    }
}
