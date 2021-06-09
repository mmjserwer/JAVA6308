package java6308.gui;

import java6308.dao.Student6308;
import java6308.dao.Student6308Dao;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class EditStudent6308Controller {
    private Student6308Dao dao = new Student6308Dao();
    private Stage dialog;
    private Dialog6308Controller controller;

    @FXML
    private BorderPane root;

    @FXML
    private TableView<Student6308> tvStudents;

    @FXML
    private TableColumn<Student6308, String> colSno;

    @FXML
    private TableColumn<Student6308, String> colSname;

    @FXML
    private TableColumn<Student6308, Integer> colLx1;

    @FXML
    private TableColumn<Student6308, Integer> colLx2;

    @FXML
    private void initialize() {
        colSno.setCellValueFactory(new PropertyValueFactory<>("sno"));
        colSname.setCellValueFactory(new PropertyValueFactory<>("sname"));
        colLx1.setCellValueFactory(new PropertyValueFactory<>("lx1"));
        colLx2.setCellValueFactory(new PropertyValueFactory<>("lx2"));
        List<Student6308> stuList = dao.findAll6308();
        tvStudents.getItems().addAll(stuList);
    }

    @FXML
    void add(ActionEvent event) {
        ObservableList<Student6308> items = tvStudents.getItems();
        if (dialog == null) {
            createDialog6308();
        }
        controller.initAdd6308();
        dialog.showAndWait();
        Student6308 stu = controller.getStudent();
        if (stu != null) {
            if(stu.getSname()!=null&&stu.getSno()!=null){
                new Student6308Dao().add6308(stu);
                items.add(stu);
                tvStudents.refresh();
                tvStudents.requestFocus();
                tvStudents.getSelectionModel().select(stu);
                tvStudents.scrollTo(stu);
            }
        }

    }

    @FXML
    void change(ActionEvent event) {
        Student6308 oldStudent = getCurrentStudent();
        if (oldStudent == null) {
            return;
        }
        if (dialog == null) {
            createDialog6308();
        }
        controller.initChange6308(oldStudent);
        dialog.showAndWait();
        Student6308 newStudent = controller.getStudent();
        if (newStudent == null ) { } else {
            dao.update6308(oldStudent.getId(), newStudent);
            newStudent.setId(oldStudent.getId());
            int index = tvStudents.getSelectionModel().getSelectedIndex();
            tvStudents.getItems().set(index, newStudent);
            tvStudents.refresh();
            tvStudents.getSelectionModel().select(newStudent);
            tvStudents.requestFocus();

        }
    }
    @FXML
    void doubleClick(MouseEvent event) {
        if (event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY) {
            change(null);
        }
    }

    @FXML
    void delete(ActionEvent event) {
        Student6308 stu = getCurrentStudent();
        if (stu == null) return;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("删除提示");
        alert.setHeaderText("请确实是否删除?" + stu.getSno());
        alert.getButtonTypes().setAll(
                ButtonType.YES,
                ButtonType.NO
        );
        Optional<ButtonType> type = alert.showAndWait();
        type.ifPresent(new Consumer<ButtonType>() {
            @Override
            public void accept(ButtonType buttonType) {
                if (buttonType == ButtonType.YES) {
                    int i = dao.delete6308(stu.getId());
                    if (i == 1) {
                        tvStudents.getItems().remove(stu);
                        tvStudents.refresh();
                        tvStudents.requestFocus();
                    }
                }
            }
        });
    }

    private Student6308 getCurrentStudent() {
        int index = tvStudents.getSelectionModel().getSelectedIndex();
        if (index < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("请注意");
            alert.setHeaderText("请选择需要修改的数据！");
            alert.show();
            return null;
        }
        return tvStudents.getItems().get(index);
    }

    private void createDialog6308() {
        URL url = getClass().getResource("Dialog6308View.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent dialogRoot = null;
        try {
            dialogRoot = loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(dialogRoot);
        dialog = new Stage();
        dialog.setScene(scene);
        Stage main = (Stage) root.getScene().getWindow();
        dialog.initOwner(main);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setResizable(false);
        dialog.setTitle("学生信息编辑窗口");
    }

}
