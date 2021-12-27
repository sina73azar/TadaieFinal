package com.tadaie.tadaiefinal.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Paper {
    private ObjectProperty<String> paperType = new SimpleObjectProperty<>();

    private ObjectProperty<String> material = new SimpleObjectProperty<>(null);
    private DoubleProperty mass = new SimpleDoubleProperty();
    private StringProperty brand = new SimpleStringProperty("");
    private StringProperty color = new SimpleStringProperty();
    private StringProperty details = new SimpleStringProperty();
    //in centimeter size varagh
    private DoubleProperty width = new SimpleDoubleProperty();
    private DoubleProperty height = new SimpleDoubleProperty();
    //size sheet
    private DoubleProperty widthSheet = new SimpleDoubleProperty();
    private DoubleProperty heightSheet = new SimpleDoubleProperty();
    //fraction size sheet to varagh
    private IntegerProperty numeratorFraction = new SimpleIntegerProperty();
    private IntegerProperty denominatorFraction = new SimpleIntegerProperty();

    public double getWidthSheet() {
        return widthSheet.get();
    }

    public DoubleProperty widthSheetProperty() {
        return widthSheet;
    }

    public double getHeightSheet() {
        return heightSheet.get();
    }

    public DoubleProperty heightSheetProperty() {
        return heightSheet;
    }

    public int getNumeratorFraction() {
        return numeratorFraction.get();
    }

    public IntegerProperty numeratorFractionProperty() {
        return numeratorFraction;
    }

    public int getDenominatorFraction() {
        return denominatorFraction.get();
    }

    public IntegerProperty denominatorFractionProperty() {
        return denominatorFraction;
    }

    private ListProperty<String> paperTypes = new SimpleListProperty<>(
            FXCollections.observableArrayList("مصرفی", "ارسالی")
    );
    //
    private ListProperty<String> materials=new SimpleListProperty<>(
            FXCollections.observableArrayList("تحریر","گلاسه",
                    "مقوا","الورن","پی وی سی","لیبل","NCR","کتان","فانتزی")
    );

    //property getters

    public String getPaperType() {
        return paperType.get();
    }

    public ObjectProperty<String> paperTypeProperty() {
        return paperType;
    }

    public ObservableList<String> getPaperTypes() {
        return paperTypes.get();
    }

    public ListProperty<String> paperTypesProperty() {
        return paperTypes;
    }

    public String getMaterial() {
        return material.get();
    }

    public ObjectProperty<String> materialProperty() {
        return material;
    }

    public double getMass() {
        return mass.get();
    }

    public DoubleProperty massProperty() {
        return mass;
    }

    public String getBrand() {
        return brand.get();
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public String getDetails() {
        return details.get();
    }

    public StringProperty detailsProperty() {
        return details;
    }

    public double getWidth() {
        return width.get();
    }

    public DoubleProperty widthProperty() {
        return width;
    }

    public double getHeight() {
        return height.get();
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public ObservableList<String> getMaterials() {
        return materials.get();
    }

    public ListProperty<String> materialsProperty() {
        return materials;
    }
}
