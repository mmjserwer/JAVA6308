package java6308.task;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.lang.reflect.Array;
import java.util.*;

public class Words6308Controller {

    @FXML
    private ListView<String> lvWords;//唯一单词列表

    @FXML
    private TextArea taWords;//输入文本内容

    @FXML
    private Label lblCount;//统计唯一单词数

    @FXML
    void buttonClick(ActionEvent event) {
        ObservableList<String> list = lvWords.getItems();//可视化集合
        list.clear();//清空list内的内容
        String text = taWords.getText();//获取输入的文本内容
        String s = text.toLowerCase();//将文本内容里面的字母变成小写字母
        String regex = "[^a-z]";//规则：除了小写字母之外的字符
        String[] str = text.split(regex);//以小写字母之外的字符作为分隔符
        Collection<String> arrayList = new TreeSet<String>();//创建treeset集合 String自带排序
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("")) {//如果字符不是空的就添加到arraylist中
                arrayList.add(str[i]);
            }
        }
        list.addAll(arrayList);//将arraylist集合内的字符添加到可视化集合内
        lblCount.setText(list.size()+"");
    }

}