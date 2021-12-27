package com.tadaie.tadaiefinal.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Print {
    private ListProperty<String> machineSizes = new SimpleListProperty<>(FXCollections.observableArrayList("جی تی او", "دوورقی", "چهارونیم ورقی","شش ورقی"));
    private ObjectProperty<String> machineSize = new SimpleObjectProperty<>();

    private ListProperty<String> machineModels = new SimpleListProperty<>(FXCollections.observableArrayList("پرینت مستر", "اسپید مستر" ,"سی دی", "یو وی"));
    private ObjectProperty<String> machineModel = new SimpleObjectProperty<>();

    private IntegerProperty colorCount = new SimpleIntegerProperty();

    private BooleanProperty mainColor = new SimpleBooleanProperty();
    private BooleanProperty makeColor = new SimpleBooleanProperty();
    private StringProperty detailMainColor = new SimpleStringProperty();
    private StringProperty detailMakeColor = new SimpleStringProperty();

    private IntegerProperty tirazh = new SimpleIntegerProperty();

    public ObservableList<String> getMachineSizes() {
        return machineSizes.get();
    }

    public ListProperty<String> machineSizesProperty() {
        return machineSizes;
    }

    public String getMachineSize() {
        return machineSize.get();
    }

    public ObjectProperty<String> machineSizeProperty() {
        return machineSize;
    }

    public ObservableList<String> getMachineModels() {
        return machineModels.get();
    }

    public ListProperty<String> machineModelsProperty() {
        return machineModels;
    }

    public String getMachineModel() {
        return machineModel.get();
    }

    public ObjectProperty<String> machineModelProperty() {
        return machineModel;
    }

    public int getColorCount() {
        return colorCount.get();
    }

    public IntegerProperty colorCountProperty() {
        return colorCount;
    }

    public boolean isMainColor() {
        return mainColor.get();
    }

    public BooleanProperty mainColorProperty() {
        return mainColor;
    }

    public boolean isMakeColor() {
        return makeColor.get();
    }

    public BooleanProperty makeColorProperty() {
        return makeColor;
    }

    public String getDetailMainColor() {
        return detailMainColor.get();
    }

    public StringProperty detailMainColorProperty() {
        return detailMainColor;
    }

    public String getDetailMakeColor() {
        return detailMakeColor.get();
    }

    public StringProperty detailMakeColorProperty() {
        return detailMakeColor;
    }

    public int getTirazh() {
        return tirazh.get();
    }

    public IntegerProperty tirazhProperty() {
        return tirazh;
    }
}
