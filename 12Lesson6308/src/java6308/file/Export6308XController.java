package java6308.file;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class Export6308XController {

    @FXML
    private TextField tfDir;//文本框

    @FXML
    private TextField tfSuffix;//文件名后缀

    @FXML
    private Button btnExport;//导出文件按钮

    @FXML
    private Label lblExport;//统计导出文件名 个数

    @FXML//导出文件的监听
    void export(ActionEvent event) {
        FileChooser fc = new FileChooser();


    }

    @FXML//选择主目录
    void getDir(ActionEvent event) {
        DirectoryChooser dc = new DirectoryChooser();


    }

}

