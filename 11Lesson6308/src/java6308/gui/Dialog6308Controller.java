package java6308.gui;

import java6308.dao.Student6308;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Dialog6308Controller {

    private Student6308 student;
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

    @FXML
    private Button btnYes;

    public Student6308 getStudent()
    {
        return student;
    }


    public void initAdd6308(){
        student=null;
        btnYes.setText("增加");
        tfSno.setText("");
        tfSname.setText("");
        tfLx1.setText("");
        tfLx2.setText("");
    }
    public void initChange6308(Student6308 oldStudent){
        student=null;
        btnYes.setText("修改");
        tfSno.setText(oldStudent.getSno());
        tfSname.setText(oldStudent.getSname());
        tfLx1.setText(oldStudent.getLx1()+"");
        tfLx2.setText(oldStudent.getLx2()+"");

    }
    @FXML
    void no(ActionEvent event) {
        ((Stage)root.getScene().getWindow()).close();
    }

    @FXML
    void yes(ActionEvent event) {
        student=new Student6308(tfSno.getText(),tfSname.getText());
        int lx1=0,lx2=0;
        try{
            lx1=Integer.parseInt(tfLx1.getText());
            lx2=Integer.parseInt(tfLx2.getText());
        }catch (Exception e){
            e.printStackTrace();
        }
        student.setLx1(lx1);
        student.setLx2(lx2);
        ((Stage)root.getScene().getWindow()).close();
    }

}
