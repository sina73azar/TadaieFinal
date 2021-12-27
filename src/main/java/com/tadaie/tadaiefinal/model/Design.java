package com.tadaie.tadaiefinal.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Design {
    private BooleanProperty graphicDesign = new SimpleBooleanProperty();
    private BooleanProperty edit = new SimpleBooleanProperty();
    private BooleanProperty reformat = new SimpleBooleanProperty();
    private StringProperty details = new SimpleStringProperty("");

    public boolean isGraphicDesign() {
        return graphicDesign.get();
    }

    public BooleanProperty graphicDesignProperty() {
        return graphicDesign;
    }

    public boolean isEdit() {
        return edit.get();
    }

    public BooleanProperty editProperty() {
        return edit;
    }

    public boolean isReformat() {
        return reformat.get();
    }

    public BooleanProperty reformatProperty() {
        return reformat;
    }

    public String getDetails() {
        return details.get();
    }

    public StringProperty detailsProperty() {
        return details;
    }
}
