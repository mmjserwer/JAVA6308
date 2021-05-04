package java6308.nio2;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

public class NIO2Dir6308Controller {

    @FXML
    private TextField tfDir;//输入地址

    @FXML
    private Label lblCount;//统计文件和目录个数

    @FXML
    private TableView<MyFile6308> tableFiles;//显示

    @FXML
    private TableColumn<MyFile6308, String> colName;//名称

    @FXML
    private TableColumn<MyFile6308, String> colTime;//修改时间

    @FXML
    private TableColumn<MyFile6308, String> colType;//类型

    @FXML
    private TableColumn<MyFile6308, String> colSize;//大小
    Set<MyFile6308> set=new TreeSet<MyFile6308>();
    ObservableList<MyFile6308> items;
    int count1 = 0;//统计子目录
    int count2 = 0;//统计文件个数

    @FXML
    private void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("modifiedTime"));
        colSize.setCellValueFactory(new PropertyValueFactory<>("size"));
    }
    //双击

    @FXML
    void doubleClick(MouseEvent event) {
        if(event.getClickCount()==2){
            MyFile6308 selectedItem = tableFiles.getSelectionModel().getSelectedItem();
            String type = selectedItem.getType();
            String path=tfDir.getText()+"\\"+type;

        }
    }
    //输入文本框
    @FXML
    void listAll(ActionEvent event) throws IOException {
        count1=0;//将上一次记录的清零 统计子目录
        count2=0;//将上一次记录的清零 统计文件个数
        items = tableFiles.getItems();//显示内容
        set.clear();
        Path path = Paths.get(tfDir.getText());//获得Path实例化对象
        if (Files.isDirectory(path)) {//路径存在
            Stream<Path> list = Files.list(path);
            items.clear();//清空之前的显示
            list.forEach(path1 -> {//遍历路径下的目录
                printInfo(path1);//显示该路径的目录
            });
            //遍历tree集合 排好序列的一个个取出
            for(MyFile6308 me:set){
                items.add(me);
            }
            lblCount.setText("文件夹个数："+count1+" 目录个数："+count2);
        } else {
            if (tfDir.getText().trim().equals("")) {
                Path path1 = Paths.get("");
                items.clear();//清空之前的显示
                printInfo(path1);//显示当前目录
            } else {
                attion();
            }

        }
    }
    private void printInfo(Path path1) {
        MyFile6308 myFile6308 = new MyFile6308();
        myFile6308.setName(path1.getFileName().toString());//设置名字
        if (Files.isDirectory(path1)) {
            myFile6308.setType("文件夹");//设置类型
            myFile6308.setSize("");//设置大小
            count1++;//文件夹个数++
        } else {
            myFile6308.setType("");//设置类型
            myFile6308.setSize(sizenum(path1.toFile().length()) + "KB");//设置大小
            count2++;//目录个数++
        }
        myFile6308.setModifiedTime(longToLocalDate(path1.toFile().lastModified()));//设置最后一次修改时间
        set.add(myFile6308);
    }

    void attion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("NIO2与TableView显示目录内容");
        alert.setHeaderText("请注意");
        alert.setContentText("目录错误");
        alert.show();
    }

    private static String longToLocalDate(long time) {
        Instant instant = Instant.ofEpochMilli(time);
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        LocalDateTime local = zone.toLocalDateTime();
        String ff = "yyyy-MM-dd HH:mm:ss";
        String format = local.format(DateTimeFormatter.ofPattern(ff));
        return format;
    }

    private static long sizenum(long length) {
        if (length > 0 && length < 1024) {
            return 1;
        } else if (length >= 1024) {
            return (length / 1024);
        }
        return 0;
    }
}

