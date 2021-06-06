package java6304.gui;

import java6304.dao.Student6304;
import java6304.dao.Student6304Dao;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class EditStudent6304Controller {

    Student6304 student;

    Alert alert;

    Stage dialog;

    Dialog6304Controller dialog6304Controller;

    @FXML
    private BorderPane root;

    @FXML
    private TableView<Student6304> tvStudents;

    @FXML
    private TableColumn<Student6304, String> colSno;

    @FXML
    private TableColumn<Student6304, String> colSname;

    @FXML
    private TableColumn<Student6304, Integer> colLx1;

    @FXML
    private TableColumn<Student6304, Integer> colLx2;

    @FXML
    void add(ActionEvent event) {
        createDialog6304();
        Objects.requireNonNull(dialog);//确保对话框已创建
        ObservableList<Student6304> items = tvStudents.getItems();
        dialog6304Controller.initAdd6304();//调用DialogXXXXController类的initAddXXXX()方法初始化对话框的显示内容
        dialog.showAndWait();//用showAndWait()方法显示对话框，并等待对话框关闭
        student = dialog6304Controller.getStudent();//调用DialogXXXXController类的getStudent()方法，得到新增的Student对象
        if (student!=null){
            if (student.getSname()!=null & student.getSno()!=null){
                new Student6304Dao().add6304(student);//调用StudentXXXXDao的addXXXX()方法向数据库中添加数据
                items.add(student);//在TableView的数据源中添加数据
                tvStudents.refresh();//调用TableView的refresh()方法同步显示修改结果
                tvStudents.getSelectionModel().select(items.size()-1);
                tvStudents.requestFocus();
                tvStudents.scrollTo(items.size()-1);
            }
        }
    }

    @FXML
    void change() {
        createDialog6304();
        ObservableList<Student6304> items = tvStudents.getItems();
        int i = tvStudents.getFocusModel().getFocusedIndex();
        if (i <0){//确保已选中要修改的数据
            hint();return;
        }
        Objects.requireNonNull(dialog);//确保对话框已创建
        dialog6304Controller.initChange6304(items.get(i));//调用DialogXXXXController类的initChangeXXXX()方法初始化对话框的显示内容
        dialog.showAndWait();//用showAndWait()方法显示对话框，并等待对话框关闭
        student= dialog6304Controller.getStudent();//调用DialogXXXXController类的getStudent()方法，得到修改后的Student对象
        if (student!=null) {
            new Student6304Dao().update6304(student.getId(), student);//调用StudentXXXXDao的updateXXXX()方法修改数据库中的数据
            items.clear();
            items.addAll(new Student6304Dao().findAll6304());
            tvStudents.refresh();//调用TableView的refresh()方法同步显示修改结果
            tvStudents.getSelectionModel().select(i);
            tvStudents.requestFocus();
        }
    }

    /**
     * 双击监听
     * @param event 监听行为
     */
    @FXML
    void doubleClick(MouseEvent event) {
        if(event.getClickCount()==2){
            change();
        }
    }

    @FXML
    void delete(ActionEvent event) {
        ObservableList<Student6304> items = tvStudents.getItems();
        createDialog6304();
        Objects.requireNonNull(dialog);//确保对话框已创建
        int i = tvStudents.getFocusModel().getFocusedIndex();//确保已选中要删除的数据
        if (i <0){
            hint();return;
        }
        //弹出确认对话框，确认是否删除
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("关闭提示");
        alert.setHeaderText("是否删除数据？");
        alert.getButtonTypes().setAll(
                ButtonType.YES,
                ButtonType.NO
        );
        Optional<ButtonType> type = alert.showAndWait();
        type.ifPresent(buttonType -> {
            if (buttonType == ButtonType.YES) {
                //调用StudentXXXXDao的deleteXXXX()方法删除数据库中的数据
                int i1 = new Student6304Dao().delete6304(items.get(i).getId());//调用StudentXXXXDao的deleteXXXX()方法删除数据库中的数据
                if (i1!=-1){
                    items.clear();
                    items.addAll(new Student6304Dao().findAll6304());//在TableView的数据源删除数据
                    tvStudents.refresh();
                }else {
                    new Alert(Alert.AlertType.INFORMATION, "删除失败").show();return;
                }
                new Alert(Alert.AlertType.INFORMATION, "数据已删除").show();
            } else {
                event.consume();
            }
        });
        tvStudents.getSelectionModel().select(0);
        tvStudents.requestFocus();
    }

    /**
     * 初始化属性
     */
    public void initialize() {
        colSno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        colSname.setCellValueFactory(new PropertyValueFactory<>("sname"));
        colLx1.setCellValueFactory(new PropertyValueFactory<>("lx1"));
        colLx2.setCellValueFactory(new PropertyValueFactory<>("lx2"));
        ObservableList<Student6304> items = tvStudents.getItems();
        List<Student6304> all6304 = new Student6304Dao().findAll6304();
        items.addAll(all6304);
        tvStudents.getSelectionModel().select(0);
    }

    /**
     * 创建对话框的功能
     */
    void createDialog6304() {
        URL url = getClass().getResource("Dialog6304View.fxml");
        FXMLLoader fxmlLoader=new FXMLLoader(url);
        dialog = new Stage();
        Scene scene = null;
        try {
            Parent load=fxmlLoader.load();
            dialog6304Controller=fxmlLoader.getController();
            scene = new Scene(load);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取窗口
        Stage main = (Stage) root.getScene().getWindow();
        dialog.setScene(scene);
        dialog.initOwner(main);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setTitle("学生信息编辑");
    }

    public void hint() {//提示框
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("学生信息编辑");
        alert.setHeaderText("请注意");
        alert.setContentText("请选择正确的数据！");
    }
}
