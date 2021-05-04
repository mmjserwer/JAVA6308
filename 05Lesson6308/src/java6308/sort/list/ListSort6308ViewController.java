package java6308.sort.list;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

import java.util.*;

public class ListSort6308ViewController {

    @FXML
    private RadioButton rb1;//按钮1

    @FXML
    private ToggleGroup tg;//按钮群
    @FXML
    private RadioButton rb2;//按钮2

    @FXML
    private RadioButton rb3;//按钮3

    @FXML
    private RadioButton rb4;//按钮4

    ObservableList<Course6308> items;//用于显示

    @FXML
    private ListView<Course6308> lvCourse;//用于显示集合


    public void initialize() {
        List<Course6308> list = new ArrayList<Course6308>();//用于最开始的集合
        list.add(new Course6308("操作系统", "2下", "B001", 3, 90));
        list.add(new Course6308("Python程序基础", "1下", "B002", 2, 85));
        list.add(new Course6308("高等数学", "1下", "0002", 2, 85));
        list.add(new Course6308("Java程序高级开发", "3上", "C001", 2, 83));
        list.add(new Course6308("大学英语", "1上", "0001", 3, 80));
        list.add(new Course6308("面向对象程序设计", "2上", "A002", 3, 78));
        list.add(new Course6308("C程序设计基础", "1上", "A001", 4, 80));
        list.add(new Course6308("数据库原理", "2上", "A003", 3, 78));
        list.add(new Course6308("网络基础", "3上", "B003", 3, 75));
        list.add(new Course6308("软件工程与UML", "3下", "C002", 3, 75));
        items = lvCourse.getItems();//可视化界面
        tg.selectToggle(rb1);//默认选择第一项
        Collections.sort(list);//成绩降序 默认显示
        items.addAll(list);//添加显示集合
        //改变的按钮监听
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                //当按到按钮1
                if (rb1.equals(tg.getSelectedToggle())) {
                    items.clear();//清空之前显示
                    Collections.sort(list);//排序
                    items.addAll(list);//添加显示集合
                }
                //当按到按钮2
                if (rb2.equals(tg.getSelectedToggle())) {
                    items.clear();//清空之前显示
                    //匿名内部类
                    list.sort(new Comparator<Course6308>() {
                        @Override
                        public int compare(Course6308 o1, Course6308 o2) {
                            //获取开课学期的第一个数字
                            int sum1 = o1.getTerm().charAt(0);
                            int sum2 = o2.getTerm().charAt(0);
                            //当开课学期的第一个数字相同时 判断第二个字符 那个字符大 那个就加上1
                            if (sum1 == sum2) {
                                String c = String.valueOf(o1.getTerm().charAt(1));
                                String d = String.valueOf(o2.getTerm().charAt(1));
                                if (c.equals("上")) {
                                    if (d.equals("下")) {
                                        sum2++;
                                    }
                                }
                                if (c.equals("下")) {
                                    if (d.equals("上")) {
                                        sum1++;
                                    }
                                }
                            }
                            return sum1 - sum2;
                        }
                    });
                    items.addAll(list);//添加显示集合
                }
                //当按到按钮3
                if (rb3.equals(tg.getSelectedToggle())) {
                    items.clear();//清空之前显示
                    list.sort(new SorterByCredit6308());//通过比较器类SorterByCredit6308进行排序
                    items.addAll(list);//添加显示集合
                }
                //当按到按钮4
                if (rb4.equals(tg.getSelectedToggle())) {
                    items.clear();//清空之前显示
                    compareff(list);//通过调用compareff方法
                    items.addAll(list);//提交显示集合
                }
            }
        });
    }

    private void compareff(List<Course6308> list) {
        Collections.sort(list, Course6308::compareTwo);
    }
}
