package java6308.ktv;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class KTVSelect6308Controller {

    @FXML
    private TextField tfNewName;//文本框内容

    @FXML
    private ListView<String> lvNames;//显示在界面

    @FXML
        //新增
    void addClick(ActionEvent event) {
        String nameText = tfNewName.getText();
        ObservableList<String> list = lvNames.getItems();
        String text = lvNames.getSelectionModel().getSelectedItem();//鼠标点的文本
        int index = lvNames.getSelectionModel().getSelectedIndex();//鼠标在点文本的所在位置
        lvNames.getSelectionModel().select(0);//跟随移动
        String s = nameText.replace(" ", "");//删除空格

        if (s.length() == 0 || s.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("KTV点歌");
            alert.setHeaderText("请注意");
            alert.setContentText("请输入内容");
            alert.show();
            return;
        }
        if (list.contains(s)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("KTV点歌");
            alert.setHeaderText("请注意");
            alert.setContentText("【" + nameText + "】" + "已在歌单中");
            alert.show();
        } else {
            list.add(nameText);
        }
    }

    @FXML
        //下移一首
    void downClick(ActionEvent event) {
        String text = lvNames.getSelectionModel().getSelectedItem();//鼠标点的文本
        int index = lvNames.getSelectionModel().getSelectedIndex();//鼠标在点文本的所在位置
        ObservableList<String> list = lvNames.getItems();
        try {
            //交换位置
            String temp = list.get(index + 1);
            list.set(index + 1, text);
            list.set(index, temp);
            lvNames.getSelectionModel().select(index + 1);//跟随移动
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("KTV点歌");
            alert.setHeaderText("请注意");
            alert.setContentText("【" + text + "】" + "已在歌单最底下");
            alert.show();
        }

    }

    @FXML
        //置顶
    void topClick(ActionEvent event) {
        String text = lvNames.getSelectionModel().getSelectedItem();//鼠标点的文本
        int index = lvNames.getSelectionModel().getSelectedIndex();//鼠标在点文本的所在位置
        ObservableList<String> list = lvNames.getItems();

        //置顶
        String temp = list.get(0);
        list.set(0, text);
        list.set(index, temp);

        lvNames.getSelectionModel().select(0);//跟随移动
        if (index + 1 == 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("KTV点歌");
            alert.setHeaderText("请注意");
            alert.setContentText("【" + text + "】" + "已经置顶了");
            alert.show();
        }


    }

    @FXML
        //上移一首
    void upClick(ActionEvent event) {
        String text = lvNames.getSelectionModel().getSelectedItem();//鼠标点的文本
        int index = lvNames.getSelectionModel().getSelectedIndex();//鼠标在点文本的所在位置
        ObservableList<String> list = lvNames.getItems();
        try {
            //交换位置
            String temp = list.get(index - 1);
            list.set(index - 1, text);
            list.set(index, temp);
            lvNames.getSelectionModel().select(index - 1);//跟随移动
        } catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("KTV点歌");
            alert.setHeaderText("请注意");
            alert.setContentText("【" + text + "】" + "已在歌单的最顶部");
            alert.show();
        }

    }

}

