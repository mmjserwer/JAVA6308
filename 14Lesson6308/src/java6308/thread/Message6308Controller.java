package java6308.thread;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Message6308Controller {


    @FXML
    private ListView<Label> lvMessages;//聊天记录

    @FXML
    private TextField tfSendMsg;//输入聊天信息

    Label label=new Label();

    @FXML
    void sendMsg(ActionEvent event) {

    }


}