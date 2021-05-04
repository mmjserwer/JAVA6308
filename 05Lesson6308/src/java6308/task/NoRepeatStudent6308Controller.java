package java6308.task;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.*;

public class NoRepeatStudent6308Controller {

    @FXML
    private TextField tfName;//输入姓名

    @FXML
    private TextField tfAge;//输入年龄

    @FXML
    private ListView<Student6308> lvStudent;//显示输入的内容
    Collection<Student6308> list = new ArrayList<Student6308>();//创建列表(可重复）
    Collection<Student6308> list1 = new HashSet<Student6308>();//用于存不重复的
    String nameText="";
    int ageText = 0;

    @FXML
//添加按钮
    void addClick(ActionEvent event) {
        //检查输入的姓名和年龄是否有错误
        if(!problemattion()){
            return;
        }
        ObservableList<Student6308> items = lvStudent.getItems();//用于显示集合
        items.clear();//每次添加先清空之前的显示

        //判断之前是否做过清空重复项
        if(list1.size()>0){
            list.clear();//做过则清空增加的集合
            list.addAll(list1);//添加做完重复项的集合
            list1.clear();//list1是删除重复的集合
        }
        list.add(new Student6308(nameText, ageText));//添加集合内元素
        items.addAll(list);//显示
    }
    @FXML
//修改按钮
    void changeClick(ActionEvent event) {

        String text = String.valueOf(lvStudent.getSelectionModel().getSelectedItem());//鼠标点的文本
        int index = lvStudent.getSelectionModel().getSelectedIndex();//鼠标在点文本的所在位置

        //检查输入的姓名和年龄是否有错误
        if(!problemattion()){
            return;
        }
        List<Student6308> list2=new ArrayList<Student6308>();//创建列表(可重复）
        //判断之前是否做过修改项  若做过则清空集合
        if(list2.size()>0){
            list2.clear();
        }
        list2.addAll(list);//将显示的元素添加到修改list集合内
        list2.set(index,new Student6308(nameText,ageText));//修改选中的项

        list.clear();//清空未修改前的集合
        list.addAll(list2);//添加修改后的集合

        ObservableList<Student6308> items = lvStudent.getItems();//用于显示集合
        items.clear();//清空之前显示的
        items.addAll(list2);//将list2显示出来

    }
    @FXML
//清空重复项按钮
    void clearClick(ActionEvent event) {
        list1.addAll(list);//往Hashset中添加list集合 通过重写方法删除重复项
        ObservableList<Student6308> items = lvStudent.getItems();//用于显示集合
        items.clear();//清空之前显示的
        items.addAll(list1);//将list显示出来
    }
    //标准pojo类 学生类
    class Student6308 {
        private String name;//姓名
        private int age;//年龄

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student6308 that = (Student6308) o;
            return age == that.age && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override//重写tostring 返回姓名和年龄
        public String toString() {
            return name + ',' + age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        //无参构造
        public Student6308() {
        }

        //有参构造
        public Student6308(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    void attion(String problem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ListView与对象集合");
        alert.setHeaderText("请注意");
        alert.setContentText(problem);
        alert.show();
    }
     boolean problemattion(){
        nameText = tfName.getText();
        //判断输入年龄和姓名同时为空的情况 判断年龄为空的情况
        try {
            ageText = Integer.parseInt(tfAge.getText());
        } catch (Exception e) {
            //判断输入的名字是否有误
            nameText.replace(" ", "");//排除空格
            if (nameText.equals("")) {
                String error = "姓名没有输入或输入全是空格,(年龄也没有输入或年龄输入错误)";
                attion(error);
                return false;
            }
            String error = "年龄没有输入或输入错误";
            attion(error);
            return false;
        }
        //判断输入姓名为空的情况
        nameText.replace(" ", "");//排除空格
        if (nameText.equals("")) {
            String error = "姓名没有输入或输入全是空格";
            attion(error);
            return false;
        }
         return true;
     }
}
