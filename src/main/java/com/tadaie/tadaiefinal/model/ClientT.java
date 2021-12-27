package com.tadaie.tadaiefinal.model;

import javafx.beans.property.*;



public class ClientT {

    private int id;

    private final StringProperty name;

    private final StringProperty phone;

    private final StringProperty company;

    private final StringProperty address;

    private final StringProperty details;

    public ClientT() {
        name = new SimpleStringProperty("");
        phone = new SimpleStringProperty("");
        company = new SimpleStringProperty("");
        address = new SimpleStringProperty("");
        details = new SimpleStringProperty("");
    }

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

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public String getCompany() {
        return company.get();
    }

    public StringProperty companyProperty() {
        return company;
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getDetails() {
        return details.get();
    }

    public StringProperty detailsProperty() {
        return details;
    }
}
