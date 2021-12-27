package com.tadaie.tadaiefinal.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hamkar {
    private int id;
    private StringProperty name = new SimpleStringProperty("");
    private StringProperty phone = new SimpleStringProperty("");
    private StringProperty address = new SimpleStringProperty("");
    private StringProperty details = new SimpleStringProperty("");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }
    public String getPhone(){return phone.get();}
    public StringProperty phoneProperty(){
        return phone;
    }
    public String getAddress(){
        return address.get();}
    public StringProperty addressProperty() {
        return address;
    }

    public String getDetails(){
        return details.get();}
    public StringProperty detailsProperty() {
        return details;
    }
}
