module com.tadaie.tadaiefinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;

    requires com.dlsc.formsfx;
    requires com.jfoenix;
    requires net.time4j.ui;
    requires net.time4j.sqlxml;
    requires net.time4j.tzdb;
    requires net.time4j.base;


    opens com.tadaie.tadaiefinal.model to net.time4j.ui, net.time4j.sqlxml, net.time4j.tzdb, net.time4j.base, java.base;
    opens com.tadaie.tadaiefinal to javafx.fxml;
    exports com.tadaie.tadaiefinal;
    exports com.tadaie.tadaiefinal.application;
    opens com.tadaie.tadaiefinal.application to javafx.fxml;

    opens com.tadaie.tadaiefinal.utils to javafx.fxml;
    exports com.tadaie.tadaiefinal.utils;
    opens com.tadaie.tadaiefinal.panes to javafx.fxml, com.dlsc.formsfx;
    exports com.tadaie.tadaiefinal.panes;
    exports com.tadaie.tadaiefinal.model;
}