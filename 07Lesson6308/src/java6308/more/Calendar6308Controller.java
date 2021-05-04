package java6308.more;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
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
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Calendar6308Controller {
    private int nowyear;//当前显示月历的年
    private int nowmonth;//当前显示月历的月
    //月历标题中的中文月份
    private final String number[] = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};
    @FXML
    private DatePicker dpSelect;//选择

    @FXML//显示日期
    private Label lblMonth;

    @FXML
    private GridPane gpDayList;//

    //月历的每个格子中添加一个Label，用于显示数字
    @FXML
    void initialize() throws Exception {
        //月历最多6行7列
        int max = 7;
        for (int i = 1; i < max; i++) {
            //月历按行显示，所以按行添加
            for (int j = 0; j < max; j++) {
                Label label = new Label();
                GridPane.setHalignment(label, HPos.CENTER);
                GridPane.setValignment(label, VPos.CENTER);
                gpDayList.add(label, j, i);
            }
        }
        dpSelect.setValue(LocalDate.now());
        onClick(null);
    }
    @FXML
    void onClick(ActionEvent event) throws Exception {
        if(dpSelect.getValue()==null){
            //如果没有选择日期,默认当天日期
            dpSelect.setValue(LocalDate.now());
        }
        int year=dpSelect.getValue().getYear();//获取年
        int month=dpSelect.getValue().getMonthValue();//获取月
        if(nowmonth==month&&nowyear==year){
                //如果年 月没有变化不重新显示日历
        }else{
            nowyear=year;
            nowmonth=month;
            //填充月历
            fill(year,month);
            //显示月历的中文标题
            lblMonth.setText(year+"年"+number[month]+"月的日历");
        }
    }
    void fill(int year, int month) {
        ObservableList<Node> list = gpDayList.getChildren();//GridPane的所有子节点
        int gpstar=8;//Gridpane显示日历的起点元素序号从8开始，分割线也是一个元素

        //清空本月第一天之前的格子
        YearMonth yearMonth=YearMonth.of(year,month);
        //本月的第一天
        LocalDate start = yearMonth.atDay(1);
        //本月第一天的星期对应的数字=需要清空的数量
        int weekstart=start.getDayOfWeek().getValue();
        int i=0;//本月第一天之前的格子内容清空
        for(;i<weekstart;i++){
            ((Label)list.get(i+gpstar)).setText("");
        }

        //填写本月日期
        int days=yearMonth.lengthOfMonth();
        int day=1;
        for(;i<weekstart+days;i++){
            ((Label)list.get(i+gpstar)).setText(""+day++);
        }

        //填写完后的格子内容清空
        for(;i<list.size()-gpstar;i++){
            ((Label)list.get(i+gpstar)).setText("");
        }


    }

}

