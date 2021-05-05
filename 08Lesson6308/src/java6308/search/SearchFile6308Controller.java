package java6308.search;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

public class SearchFile6308Controller {

    @FXML
    private ListView<String> lvFiles;//显示

    @FXML
    private Label dqml;//显示当前目录

    @FXML
    private Button button;//选择目录按钮

    @FXML
    private TextField tfDir;//文本框

    @FXML
    private Label lblCount;//统计搜索当前目录文件个数

    @FXML
    void listAll(ActionEvent event) {
        //监听文本框
        tfDir.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });
    }

    public void clickon(ActionEvent actionEvent) {
        DirectoryChooser directoryChooser=new DirectoryChooser();
        directoryChooser.setTitle("选择文件夹");
        File file = directoryChooser.showDialog(new MyWindow());
        if(file!=null){
            tfDir.setText(file.getAbsolutePath());
        }else{

        }

    }
    public static class MyWindow extends Window{

    }
    void attion(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("NIO2与TableView显示目录内容");
        alert.setHeaderText("请注意");
        alert.setContentText("目录错误");
        alert.show();
    }
}

