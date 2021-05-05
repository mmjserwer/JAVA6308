package java6308.search;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SearchFile6308Controller {

    @FXML
    private ListView<String> lvFiles;//显示

    @FXML
    private Label dqml;//显示当前目录

    @FXML
    private TextField tfDir;//文本框

    @FXML
    private Label lblCount;//统计搜索当前目录文件个数

    private List<String> list1 = new ArrayList<String>();//存子目录
    private List<String> list2 = new ArrayList<String>();//存文件
    ObservableList<String> items;

    private void initialize() {
        tfDir.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    tfDir.setText("");
            }
        });
    }

    public void clickon(ActionEvent actionEvent) throws IOException {
        initialize();
        items = lvFiles.getItems();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("选择文件夹");
        File file = directoryChooser.showDialog(new MyWindow());
        if (file != null) {
            tfDir.setText(file.getAbsolutePath());
            dqml.setText("当前目录：" + file.getAbsolutePath());
            obser(file);
        } else {
            attion();
        }
    }

    private void obser(File file) throws IOException {
        items.clear();
        list1.clear();
        list2.clear();
        Path path = Paths.get(file.getAbsolutePath());
        Stream<Path> list = Files.list(path);
        list.forEach(path1 -> printInfo(path1));
        list1.sort(String.CASE_INSENSITIVE_ORDER);
        list2.sort(String.CASE_INSENSITIVE_ORDER);
        items.addAll(list1);
        items.addAll(list2);
        lblCount.setText("子目录：" + list1.size() + ",文件:" + list2.size());
    }

    private void printInfo(Path path1) {
        if (Files.isDirectory(path1)) {
            list1.add(path1.toFile().getName() + ",文件夹");
        } else {
            list2.add(path1.toFile().getName() + "," + path1.toFile().getName().substring(path1.toFile().getName().lastIndexOf(".") + 1) + "类型");
        }
    }

    public static class MyWindow extends Window {

    }

    void attion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("动态搜索文件");
        alert.setHeaderText("请注意");
        alert.setContentText("未选择错误");
        alert.show();
    }

}

