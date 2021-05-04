package java6308.lesson07;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class ListFile6308Controller {

    @FXML
    private ListView<String> lvFiles;//显示目录

    @FXML
    private TextField tfDir;//输入目录地址

    @FXML
    private Label lblCount;//统计子目录个数，文件个数
    ObservableList<String> items;

    //对输入框的监听
    @FXML
    void listAll(ActionEvent event) {
        items = lvFiles.getItems();
        items.clear();
        lblCount.setText("");
        File file = new File(tfDir.getText());
        finalize(file);

    }

    private void finalize(File file) {
        int count1 = 0;//统计子目录
        int count2 = 0;//统计文件个数
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File me : files) {
                if (me.isDirectory()) {
                    items.add("文件夹,    " + me.getName() + ",    " + longToLocalDate(me.lastModified()));
                    count1++;
                }

            }
            for (File me : files) {
                if (!me.isDirectory()) {
                    items.add(me.getName() + ",   " + longToLocalDate(me.lastModified()) + ",  " + sizenum(me.length()) + "K");
                    count2++;
                }
            }
        }
        lblCount.setText("子目录：" + count1 + "，文件：" + count2);
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
        if(length>0&&length<1024){
            return 1;
        }else if(length>=1024){
            return (length/1024);
        }
        return 0;
    }
}