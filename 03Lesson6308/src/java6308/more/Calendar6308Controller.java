package java6308.more;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Calendar6308Controller {

    private Label label[] = new Label[42];//子类项
    @FXML
    private DatePicker dpSelect;

    @FXML//显示日期
    private Label lblMonth;

    @FXML
    private GridPane gpDayList;

    @FXML
    private void initialize() {
        LocalDate now = LocalDate.now();
        String format = now.toString();
        String[] str = format.split("-");
        int a[] = new int[str.length];
        String number[] = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};
        try {
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
        } catch (Exception e) {
            return;
        }
        String yue = number[a[1]];
        String lj = a[0] + "年" + yue + "月的日历";
        lblMonth.setText(lj);

        //填充网格里面的日期
        LocalDate select = LocalDate.of(a[0], a[1], a[2]);//获取选择日期
        LocalDate first = select.with(TemporalAdjusters.firstDayOfMonth());//获取这个月的第一天
        LocalDate last = select.with(TemporalAdjusters.lastDayOfMonth());//获取这个月的最后一天

        int rq = 1;//负责给Label里面填充应该填的数字
        DayOfWeek firstDayOfWeek = first.getDayOfWeek();
        for (int i = 0; i < last.getDayOfMonth() + firstDayOfWeek.getValue(); i++) {
            label[i] = new Label();

            label[i].setText("");//空内容  知道到这个星期的第一天开始

        }
    }

    @FXML
    void onClick(ActionEvent event) throws Exception {
        //将DatePiker的日期在label输出出来
        try {
            TextField editor = dpSelect.getEditor();
            String[] str = editor.getText().split("-");
            int a[] = new int[str.length];
            String number[] = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};

            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            String yue = number[a[1]];
            String lj = a[0] + "年" + yue + "月的日历";
            lblMonth.setText(lj);

            //填充网格里面的日期
            LocalDate select = LocalDate.of(a[0], a[1], a[2]);//获取选择日期
            LocalDate first = select.with(TemporalAdjusters.firstDayOfMonth());//获取这个月的第一天
            LocalDate last = select.with(TemporalAdjusters.lastDayOfMonth());//获取这个月的最后一天

            int rq = 1;//负责给Label里面填充应该填的数字
            DayOfWeek firstDayOfWeek = first.getDayOfWeek();
            for (int i = 0; i < last.getDayOfMonth() + firstDayOfWeek.getValue(); i++) {
                label[i] = new Label();
                if (i >= firstDayOfWeek.getValue()) {
                    label[i].setText("" + rq);//为每个label赋值
                    rq++;
                } else {
                    label[i].setText("");//空内容  知道到这个星期的第一天开始
                }
            }
            rq = 0;//初始化数组内
            for (int i = 1; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    gpDayList.add(label[rq], j, i);//往网格里面填写日期
                    GridPane.setHalignment(label[rq], HPos.CENTER );
                    rq++;
                }
            }
        } catch (Exception e) {
            return;
        }
    }


}

