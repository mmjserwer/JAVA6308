package java6308.more;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;
import java.util.function.Consumer;

public class StudyCloseXXXX extends Application {
    private Label lblMessage;
    Button btnOpen, btnClose, btnExit, btnOpenModal;
    private Stage currentWin;

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) {
        currentWin = primaryStage;
        primaryStage.setScene(new Scene(getRoot(), 600, 300));
        primaryStage.setTitle("窗口的关闭");
        primaryStage.show();

        //打开一个普通窗口
        btnOpen.setOnAction(this::open);
        //打开一个模态窗口
        btnOpenModal.setOnAction(this::openModal);
        //关闭当前窗口
        btnClose.setOnAction(e -> primaryStage.close());
        //结束JavaFX应用程序
        btnExit.setOnAction(e -> Platform.exit());
        //关闭窗口前的处理
        primaryStage.setOnCloseRequest(this::isClose);
    }


    private Parent getRoot() {
        VBox root = new VBox(40);
        lblMessage = new Label("关闭窗口的方法");
        HBox hBox = new HBox(60);
        btnOpen = new Button("Open");
        btnOpenModal = new Button("Open模态");
        btnClose = new Button("Close");
        btnExit = new Button("Exit");
        hBox.getChildren().addAll(btnOpen, btnOpenModal, btnClose, btnExit);
        root.getChildren().addAll(lblMessage, hBox);
        hBox.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        return root;
    }

    /**
     * 打开一个普通窗口
     * @param event
     */
    private void open(ActionEvent event) {
        Stage win = new Stage();
        win.setTitle("new");
        win.setScene(new Scene(new Label("新窗口"), 300, 150));
        win.show();
    }

    /**
     * 打开一个模态窗口
     * @param actionEvent
     */
    private void openModal(ActionEvent actionEvent) {
        Stage win = new Stage();
        win.setTitle("模态");
        win.setScene(new Scene(new Label("模态窗口"), 300, 150));
        win.initOwner(currentWin);
        win.initModality(Modality.WINDOW_MODAL);
        win.show();
    }

    /**
     * 窗口关闭前的判断
     * @param event
     */
    private void isClose(WindowEvent event) {

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
                    lblMessage.setText("取消");
                    event.consume();
                }
            }
        });
    }
}
