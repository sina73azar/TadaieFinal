package com.tadaie.tadaiefinal.utils;

import com.tadaie.tadaiefinal.MainLauncher;
import com.tadaie.tadaiefinal.application.HomeApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


import java.net.URL;



public class MyFxmlLoader {
    private Pane view;

    public Pane getPage(String fileName) {
        try {
            URL fileUrl = MainLauncher.class.getResource("fxml/"+fileName+".fxml");

            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("file could not be found");
            }
            view = FXMLLoader.load(fileUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }
}
