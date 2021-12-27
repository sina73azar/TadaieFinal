package com.tadaie.tadaiefinal.model;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import net.time4j.calendar.PersianCalendar;
import net.time4j.tz.repo.TZDATA;
import net.time4j.ui.javafx.CalendarPicker;
import net.time4j.ui.javafx.CellCustomizer;

import java.util.Locale;

public class MyPersianDate {
    private HBox datePickerBox;
    private CalendarPicker<PersianCalendar> startDate;
    private CalendarPicker<PersianCalendar> endDate;


    public MyPersianDate(){
        TZDATA.init();
    }
    public HBox getDatePickerBox(){
        if (datePickerBox == null) {
            datePickerBox=createBoxDate();
        }
        return datePickerBox;
    }
    public CalendarPicker<PersianCalendar> getStartDate(){
        return startDate;}
    public CalendarPicker<PersianCalendar> getEndDate(){
        return endDate;}

    private HBox createBoxDate() {
        HBox box = new HBox();
        startDate = CalendarPicker.persianWithSystemDefaults();
        MyPersianDate.this.startDate.setLengthOfAnimations(Duration.seconds(0.7));
        startDate.setPromptText("تاریخ شروع");
        MyPersianDate.this.startDate.setLocale(new Locale("fa", "IR"));
        startDate.setShowWeeks(false);
        startDate.getStyleClass().add("calendarHbox");
        MyPersianDate.this.startDate.setCellCustomizer(
                (cell, column, row, model, date) -> {

                    if (CellCustomizer.isWeekend(column, model)) {
                        cell.setStyle("-fx-background-color: #FFE0E0;");
                        cell.setDisable(true);
                    }
                });
        endDate = CalendarPicker.persianWithSystemDefaults();
        MyPersianDate.this.endDate.setLengthOfAnimations(Duration.seconds(0.7));
        endDate.setPromptText("تاریخ تحویل");
        MyPersianDate.this.endDate.setLocale(new Locale("fa", "IR"));
        endDate.setShowWeeks(false);
        endDate.getStyleClass().add("calendarHbox");

        MyPersianDate.this.endDate.setCellCustomizer(
                (cell, column, row, model, date) -> {

                    if (CellCustomizer.isWeekend(column, model)) {
                        cell.setStyle("-fx-background-color: #FFE0E0;");
                        cell.setDisable(true);
                    }
                });
        startDate.setMinWidth(300);
        endDate.setMinWidth(300);
        box.getChildren().addAll(MyPersianDate.this.startDate,endDate);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(15);
        return box;
    }
}
