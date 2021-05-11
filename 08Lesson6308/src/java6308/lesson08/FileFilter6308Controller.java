package java6308.lesson08;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class FileFilter6308Controller {

    @FXML
    private TextField tfDir;//文本框

    @FXML
    private Label lblMsg;//路径错误显示

    @FXML
    private ListView<String> lvFiles;//显示

    @FXML
    private RadioButton rb1;//按钮1

    @FXML
    private ToggleGroup tg;//按钮集合

    @FXML
    private RadioButton rb2;//按钮2

    @FXML
    private RadioButton rb3;//按钮3

    private ObservableList<String> items;//显示
    private List<String> list1;//后缀名为java的文件
    private List<String> list2;//大于2K的文件
    private List<String> list3;//3天前到现在修改过的文件

    //时间计算
    private static LocalDateTime rq = LocalDateTime.now();
    private static LocalDateTime rq1 = rq.minusDays(3);
    private static long milli = rq1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

    @FXML
    void listFile(ActionEvent event) throws IOException {
        initialize();
        lblMsg.setText("");//提示清空
        items = lvFiles.getItems();
        tg.selectToggle(rb1);//默认选择第一个
        inner6308();//显示
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                //匿名内部类
                if (rb1.equals(tg.getSelectedToggle())) {
                    try {
                        inner6308();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //Lambda表达式
                if (rb2.equals(tg.getSelectedToggle())) {
                    try {
                        lambda6308();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //方法引用
                if (rb3.equals(tg.getSelectedToggle())) {

                    try {
                        reference6308();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    void initialize() {
        list1 = new ArrayList<String>();
        list2 = new ArrayList<String>();
        list3 = new ArrayList<String>();
    }

    //匿名内部类
    void inner6308() throws IOException {
        if (lujinpanduan().equals("1")) {
            lblMsg.setText("路径错误");
            attion();
            return;
        }
        list(lujinpanduan(), new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        list(lujinpanduan(), new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).length() > 2 * 1024;
            }
        });

        list(lujinpanduan(), new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).lastModified() > milli;
            }
        });
        clearobser();
    }

    //lambda表达式
    void lambda6308() throws IOException {
        if (lujinpanduan().equals("1")) {
            lblMsg.setText("路径错误");
            attion();
            return;
        }
        list(lujinpanduan(), (dir, name) -> name.endsWith(".java"));
        list(lujinpanduan(), (dir, name) -> new File(dir, name).length() > 2 * 1024);
        list(lujinpanduan(), (dir, name) -> new File(dir, name).lastModified() > milli);
        clearobser();
    }

    //方法引用
    void reference6308() throws IOException {
        if (lujinpanduan().equals("1")) {
            attion();
            lblMsg.setText("路径错误");
            return;
        }
        list(lujinpanduan(), refer::way1);
        list(lujinpanduan(), refer::way2);
        list(lujinpanduan(), refer::way3);
        clearobser();
    }

    //方法引用 接口
    @FunctionalInterface
    interface Function<T> {
        FilenameFilter calc(File dir, String name);
    }

    static class refer implements Function<Boolean> {
        File file;
        String s;

        public refer() {
        }

        public refer(File file, String s) {
            this.file = file;
            this.s = s;
        }

        static boolean way1(File file, String s) {
            return file.getName().endsWith(".java");
        }

        static boolean way2(File file, String s) {
            return file.length() > 2 * 1024;
        }

        static boolean way3(File file, String s) {
            return file.lastModified() > milli;
        }

        @Override
        public FilenameFilter calc(File dir, String name) {
            return null;
        }
    }

    //添加到集合内
    void list(String dir, FilenameFilter filter) {
        File file = new File(dir);
        File[] files = file.listFiles(filter);
        for (File f : files) {
            if (f.getName().endsWith(".java")) {
                if (!list1.contains(f.getAbsolutePath())) {
                    list1.add(f.getAbsolutePath());
                }
            }
            if (f.length() > 2 * 1024) {
                if (!list2.contains(f.getAbsolutePath())) {
                    list2.add(f.getAbsolutePath());
                }
            }
            if (f.lastModified() > milli) {
                if (!list3.contains(f.getAbsolutePath())) {
                    list3.add(f.getAbsolutePath());
                }
            }
        }
        lvFiles.getItems().clear();
        lvFiles.getItems().addAll(list1);
        lvFiles.getItems().addAll(list2);
        lvFiles.getItems().addAll(list3);
    }

    //弹窗 路径错误弹窗
    void attion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("NIO2与TableView显示目录内容");
        alert.setHeaderText("请注意");
        alert.setContentText("目录错误");
        alert.show();
    }

    //显示和清空
    private void clearobser() {
        items.clear();
        items.add("(1)后缀为java的文件：" + list1.size() + "个");
        items.addAll(list1);
        items.add("(2)大于2K的文件：" + list2.size() + "个");
        items.addAll(list2);
        items.add("(3)3天前到现在修改过的文件：" + list3.size() + "个");
        items.addAll(list3);
        list1.clear();
        list2.clear();
        list3.clear();
        lblMsg.setText("");
    }

    private String lujinpanduan() throws IOException {
        //处理空格
        if (tfDir.getText().trim().equals("")) {//指向当前路径
            Path path1 = Paths.get(".");
            return path1.toAbsolutePath().toString();
        }
        Path path = Paths.get(tfDir.getText());//获得Path实例化对象
        if (Files.isDirectory(path)) {//路径存在
            return path.toAbsolutePath().toString();
        } else {//路径不存在
            return "1";
        }
    }
}