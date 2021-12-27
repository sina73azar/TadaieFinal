package com.tadaie.tadaiefinal.utils;

import javafx.scene.text.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Utils {
    public static Font loadCustomFont(){
        try {
            InputStream inputStream = new FileInputStream(new File("src/main/resources/com/tadaie/tadaiefinal/fonts/zar1.ttf"));
//            InputStream inputStream = MainLauncher.class.getClassLoader().getResourceAsStream("zar1.ttf");

            return Font.loadFont(inputStream, 17);
        } catch (Exception e) {
            System.out.println("font file could not be found");
            e.printStackTrace();
            return null;
        }
    }
//    public static Font loadBoldFont(){
//
//    }
}
