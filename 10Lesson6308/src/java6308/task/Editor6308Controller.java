package java6308.task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;
import java.util.function.Consumer;

public class Editor6308Controller {

    @FXML
    private TextField tfFilename;

    @FXML
    private TextArea taText;

    @FXML
    void openFile(ActionEvent event) {



    }

    @FXML
    void saveAsFile(ActionEvent event) {

    }

    @FXML
    void saveFile(ActionEvent event) {

    }

    public void setCloseRequest(Stage primaryStage) {
        primaryStage.setOnCloseRequest(this::inclose);
    }

    private void inclose(WindowEvent windowEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("关闭提示");
        alert.setHeaderText("是否保存数据？");
        alert.getButtonTypes().setAll(
                ButtonType.YES,
                ButtonType.NO,
                ButtonType.CANCEL
        );
        Optional<ButtonType> type = alert.showAndWait();
        type.ifPresent(new Consumer<ButtonType>() {
            @Override
            public void accept(ButtonType buttonType) {
                if (buttonType == ButtonType.YES) {
                    new Alert(Alert.AlertType.INFORMATION, "数据已保存").show();
                } else if (buttonType == ButtonType.NO) {
                    new Alert(Alert.AlertType.INFORMATION, "不保存数据").show();
                } else {
                    windowEvent.consume();
                }
            }
        });

    }
}