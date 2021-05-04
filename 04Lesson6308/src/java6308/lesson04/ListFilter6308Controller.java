package java6308.lesson04;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ListFilter6308Controller {

    @FXML
    private ListView<Integer> lvAll;

    @FXML
    private Label lbl5;

    @FXML
    private ListView<Integer> lv5;

    @FXML
    void buttonClick(ActionEvent event) {
        createList6308();
        findList6308(lvAll);
    }

    //负责随机产生20个[60,100]的整数，存储到集合中
    private void createList6308() {
        List<Integer> list = new ArrayList<Integer>();
        Random rand = new Random();//生成随机数
        while (list.size() <= 20) {
            Integer a=rand.nextInt(100 - 60+1) + 60;//生成60-100内的整数
            if (a<= 100 && a >= 60) {
                list.add(a);//只保存60-100内的
            }
        }
        ObservableList<Integer> list1 = FXCollections.observableArrayList(list);
        lvAll.setItems(list1);//显示list1集合内的元素
    }

    //负责从一个集合中提取5的倍数的数据，放到另一个集合
    private void findList6308(ListView<Integer> lvAll) {
        ObservableList<Integer> list2 = lvAll.getItems();//将lvall集合内的元素保存到list2中
        ObservableList<Integer> list3 = FXCollections.observableArrayList(list2); //list2中的元素保存到list3中
        list3.clear();//清空list3集合 获得一个可以显示在面板的集合
        Iterator<Integer> iterator = list2.iterator();
        int k = 0;//5倍数的个数
        try {
            //判断集合内是否还有元素
            while (iterator.hasNext()) {
                Integer b=iterator.next();
                //如果集合内元素能被5整除保存的list3中
                if (b%5==0) {
                    list3.add(b);
                    k++;
                }
            }
        } catch (Exception e) {

        }
        lv5.setItems(list3);//显示出list3集合的元素
        lbl5.setText("其中：5的倍数有" + k + "个");
    }
}
