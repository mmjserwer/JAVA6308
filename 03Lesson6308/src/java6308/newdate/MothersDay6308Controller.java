package java6308.newdate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseEvent;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class MothersDay6308Controller {

    @FXML
    private Spinner<Integer> sYear;

    @FXML
    private Label lblMothersDay;


    @FXML
    void buttonClick(MouseEvent event){
        LocalDate date=LocalDate.of(sYear.getValue(), Month.MAY,1);
        TemporalAdjuster adjuster= TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY);
        LocalDate date1=date.with(adjuster);
        TemporalAdjuster adjuster1 = TemporalAdjusters.next(DayOfWeek.SUNDAY);
        LocalDate date2=date1.with(adjuster1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 EEE", Locale.CHINESE);
        String s = date2.format(formatter);
        lblMothersDay.setText(s);
    }
}

