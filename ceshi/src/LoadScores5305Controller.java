import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoadScores5305Controller {

    @FXML
    private Label lblFilename;

    @FXML
    private TableView<Score5305> tvScores;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colChinese;

    @FXML
    private TableColumn<?, ?> colMath;

    @FXML
    private TableColumn<?, ?> colEnglish;

    @FXML
    private TableColumn<?, ?> colSum;

    @FXML
    void openFile(ActionEvent event) throws Exception {
        //（1）new一个FileChooser

        FileChooser fileChooser = new FileChooser();

        //（2）设置标题
        fileChooser.setTitle("请选择学生文件");

        //（3）设置初始目录
        fileChooser.setInitialDirectory(new File("D:\\IDEA\\Java5305"));

        //（4）如下图所示设置两种文件过滤：*.txt和*.*
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("文本文件(*.txt)", "*.txt"), new FileChooser.ExtensionFilter("所有(*.*)", "*.*"));

        //（5）打开对话框
        //得到打开的文件
        File file = fileChooser.showOpenDialog(new Stage());

        //单击取消
        if (file == null) {
            return;
        }

        //创建字符缓冲流
        List<Score5305> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        // 根据每行数据创建Score5305对象,逗号作为分隔符
        while ((line = br.readLine()) != null)
        {
            String[] strs=line.split(",");
            try {
                Score5305 s = new Score5305(strs[0], Integer.parseInt(strs[1]), Integer.parseInt(strs[2]), Integer.parseInt(strs[3]));
                s.getSun();
                list.add(s);
            }
            catch (Exception e)
            {
                System.out.println("存在无效数据,自动跳过");
            }

        }
        //并按总分降序排列，总分相同时按数学成绩降序排列
        list.sort((o1, o2) -> {
            int num=o2.getSun()-o1.getSun();

            return num==0?o2.getMath()-o1.getMath():num;
        });
        ObservableList<Score5305> list1= FXCollections.observableArrayList(list);
        tvScores.setItems(list1);
        tvScores.getItems();


    }
    @FXML
    private void initialize()
    {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colChinese.setCellValueFactory(new PropertyValueFactory<>("chinese"));
        colMath.setCellValueFactory(new PropertyValueFactory<>("math"));
        colEnglish.setCellValueFactory(new PropertyValueFactory<>("english"));
        colSum.setCellValueFactory(new PropertyValueFactory<>("sum"));
    }
}
