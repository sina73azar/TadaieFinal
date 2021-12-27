package com.tadaie.tadaiefinal.application;

import com.dlsc.formsfx.model.structure.Form;
import com.tadaie.tadaiefinal.MainLauncher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;



import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;


public class HomeApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {

//        Font.loadFont(getClass().getResourceAsStream("zar1.ttf"), 12);
        FXMLLoader fxmlLoader = new FXMLLoader(MainLauncher.class.getResource("fxml/home_page_responsive.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMinWidth(1000.0);
        stage.setMinHeight(500.0);
        stage.setTitle("Tadaie");

        stage.initStyle(StageStyle.DECORATED);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}