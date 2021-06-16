package java6308.thread;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;

import java.net.Socket;

public class Message6308Controller {
    private Socket socket;

    public void setSocket(Socket socket) {
    }

    @FXML
    private ListView<Label> lvMessages;//聊天记录

    @FXML
    private TextField tfSendMsg;//输入聊天信息

    @FXML
    void sendMsg(ActionEvent event) {
        String text = tfSendMsg.getText();

    }
    public void setvisavle() {
        Label label = new Label();
        label.setWrapText(true);
        label.setPrefWidth(lvMessages.getWidth()-50);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setTextAlignment(TextAlignment.RIGHT);
        label.setTextFill(Paint.valueOf("#349a53"));
    }

}