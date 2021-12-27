package com.tadaie.tadaiefinal.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Lito {
    //
    private ListProperty<String> types = new SimpleListProperty<>(FXCollections.observableArrayList("مصرفی", "ارسالی"));
    private ListProperty<String> type = new SimpleListProperty<>(FXCollections.observableArrayList());
    //
    private BooleanProperty haveMasrafi = new SimpleBooleanProperty();


    private BooleanProperty haveErsali = new SimpleBooleanProperty();
    private IntegerProperty masrafiCount = new SimpleIntegerProperty();
    private IntegerProperty ersaliCount = new SimpleIntegerProperty();
    //
    private ListProperty<String> machineSizes = new SimpleListProperty<>(FXCollections.observableArrayList("جی تی او", "دوورقی", "چهارونیم ورقی", "شش ورقی"));
    private ObjectProperty<String> machineSize = new SimpleObjectProperty<>();
    private ListProperty<String> machineModels = new SimpleListProperty<>(FXCollections.observableArrayList("پرینت مستر", "اسپید مستر", "سی دی", "یو وی"));
    private ObjectProperty<String> machineModel = new SimpleObjectProperty<>();

    //
    private ListProperty<String> filmMachines = new SimpleListProperty<>(FXCollections.observableArrayList("جی تی او", "دوورقی", "چهارونیم ورقی"));
    private ObjectProperty<String> filmMachine = new SimpleObjectProperty<>();

    //color multi selection list
    private ListProperty<String> colorsList = new SimpleListProperty<String>(FXCollections.observableArrayList(" (آبی)۱", "۲", "۳", "۴", "۵", "۶", "۷", "۸", "۹", "۱۰"));
    private ListProperty<String> colorSelected = new SimpleListProperty<>(FXCollections.observableArrayList());


    //details lito
    private StringProperty details = new SimpleStringProperty("");

    public ObservableList<String> getColorsList() {
        return colorsList.get();
    }

    public ListProperty<String> colorsListProperty() {
        return colorsList;
    }

    public ObservableList<String> getColorSelected() {
        return colorSelected.get();
    }

    public ListProperty<String> colorSelectedProperty() {
        return colorSelected;
    }

    public ListProperty<String> machineSizesProperty() {
        return machineSizes;
    }


    public ObjectProperty<String> machineSizeProperty() {
        return machineSize;
    }


    public ListProperty<String> machineModelsProperty() {
        return machineModels;
    }


    public ObjectProperty<String> machineModelProperty() {
        return machineModel;
    }

    public BooleanProperty haveMasrafiProperty() {
        return haveMasrafi;
    }


    public BooleanProperty haveErsaliProperty() {
        return haveErsali;
    }

    public IntegerProperty masrafiCountProperty() {
        return masrafiCount;
    }


    public IntegerProperty ersaliCountProperty() {
        return ersaliCount;
    }

    public ObservableList<String> getTypes() {
        return types.get();
    }

    public ListProperty<String> typesProperty() {
        return types;
    }

    public ObservableList<String> getType() {
        return type.get();
    }

    public ListProperty<String> typeProperty() {
        return type;
    }

    public ObservableList<String> getFilmMachines() {
        return filmMachines.get();
    }

    public ListProperty<String> filmMachinesProperty() {
        return filmMachines;
    }

    public String getFilmMachine() {
        return filmMachine.get();
    }

    public ObjectProperty<String> filmMachineProperty() {
        return filmMachine;
    }


    public String getDetails() {
        return details.get();
    }

    public StringProperty detailsProperty() {
        return details;
    }
}
