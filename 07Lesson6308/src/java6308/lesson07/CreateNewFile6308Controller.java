package java6308.lesson07;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;

public class CreateNewFile6308Controller {

    @FXML
    private TextField tfFilename;

    @FXML
    private Label lblMessage;

    @FXML
    void listAll(ActionEvent event) throws IOException {
        String trim = tfFilename.getText().trim();
        File file = new File(trim);
        if (!file.exists()) {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                if (!parent.mkdirs()) {
                    throw new IOException("不能创建目录：" + parent);
                }
                lblMessage.setText("创建目录：" + parent);
            }
            file.createNewFile();
            lblMessage.setText("创建新文件：" + file.getAbsolutePath());
        } else {
            lblMessage.setText("文件已存在");
        }
    }
    //【问题1】图中第27～33行代码的作用是什么？如果删除这段代码会产生什么影响，请举例说明？
    //判断父目录是否存在,不存在判断是否可以创建父目录 可以则创建 删除这段代码 当多目录时报错
    // 【问题2】请查阅资料，说明图中第27行的getParentFile()
    //传入String参数 返回父目录
    // 【问题3】请举个例子说明图中第28行的判断条件parent!=null排除的是哪种情况？
    //排除父目录为空的情况
    // 【问题4】如果图中第29行的mkdirs()改用mkdir()，程序是否受到影响，请举个例子说明。
    //会，当目录多的时候会报错 e:\java\java\java\temp.text
    // 【问题5】如果输入f:\java\temp.txt，而电脑没有f盘，运行结果是什么？
    //报错 抛异常
}

