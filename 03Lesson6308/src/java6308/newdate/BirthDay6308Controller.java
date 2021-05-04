package java6308.newdate;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class BirthDay6308Controller {
    @FXML
    private DatePicker dpBirthDay;

    @FXML
    private Label lblResult;

    @FXML
    void change(ActionEvent event) throws Exception {
        try {
            LocalDate value = dpBirthDay.getValue();//出生日期
            LocalDate now = LocalDate.now();//今日日期
            int days1= value.getDayOfMonth();//获取出生的单月的天
            //判断29号生日  下一次生日改成28号
            if (value.getDayOfMonth() == 29) {
                if (now.getYear() % 400 == 0 || (now.getYear() % 4 == 0 && now.getYear() % 100 != 0)) {
                    days1=days1-1;
                }
                else{
                    days1=days1;
                }
            }
            if(value.getYear()== now.getYear()){
                if(value.getDayOfYear()>now.getDayOfYear()){
                    lblResult.setText("日期填写有误,重填");
                    return;
                }
            }
            LocalDate date = LocalDate.of(now.getYear(), value.getMonth(), days1);//转换成该年生日的日期
            long year = value.until(now, ChronoUnit.YEARS);//计算下一次生日多少岁
            int day = date.getDayOfYear() - now.getDayOfYear();//计算今年生日天数减去到今天为止的天数
            if (day < 0) {
                //day小于0代表生日已经过了
                year = year + 1;//年龄加1
                LocalDate date1 = LocalDate.of(Math.toIntExact(year), value.getMonth(), value.getDayOfMonth());//明年生日的日期
                day = now.lengthOfYear() - now.getDayOfYear() + date1.getDayOfYear();//求今天到明天生日需要多少天
            }
            lblResult.setText("还有" + day + "天," + year + "岁生日，有惊喜！");
        } catch (Exception e) {
            lblResult.setText("日期填写有误,重填");
        }
    }

}

