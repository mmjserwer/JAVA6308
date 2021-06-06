package java6304.gui;

import java6304.dao.Student6304;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Dialog6304Controller {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField tfSno;

    @FXML
    private TextField tfSname;

    @FXML
    private TextField tfLx1;

    @FXML
    private TextField tfLx2;

    Student6304 student;

    /**
     * 将窗口中输入的信息封装为Student对象，并关闭窗口
     */
    @FXML
    void yes(ActionEvent event) {
        try {
            if (tfSno.getText().trim().equals("") | tfSname.getText().trim().equals("")){
                throw new NumberFormatException();
            }
            student.setSname(tfSname.getText());
            student.setSno(tfSno.getText());
            student.setLx1(tfLx1.getText().isEmpty()?0:Integer.parseInt(tfLx1.getText()));
            student.setLx2(tfLx2.getText().isEmpty()?0:Integer.parseInt(tfLx2.getText()));
            Stage window = (Stage) root.getScene().getWindow();
            window.close();
        }catch (NumberFormatException e){
            new Alert(Alert.AlertType.INFORMATION, "请输入正确格式的数据！").show();event.consume();
        }
    }

    /**
     * 关闭窗口
     */
    @FXML
    void no() {
        Stage window = (Stage) root.getScene().getWindow();
        student = null;
        window.close();
    }

    /**
     * @return 返回Student对象
     */
    Student6304 getStudent() {
        return student;
    }

    /**
     * 清空所有文本框的内容
     */
    void initAdd6304() {
        student=new Student6304();
        tfSno.clear();
        tfSname.clear();
        tfLx1.clear();
        tfLx2.clear();
    }

    /**
     * 在窗口上显示Student对象的各个属性
     * @param student6304 传入的Student对象
     */
    void initChange6304(Student6304 student6304) {
        student = new Student6304();
        student.setId(student6304.getId());
        student.setSname(student6304.getSname());
        student.setSno(student6304.getSno());
        student.setLx1(student6304.getLx1());
        student.setLx2(student6304.getLx2());
        tfSno.setText(student6304.getSno());
        tfSname.setText(student6304.getSname());
        tfLx1.setText("" + student6304.getLx1());
        tfLx2.setText("" + student6304.getLx2());
    }

    public void initialize() {
        student = null;
    }
}
