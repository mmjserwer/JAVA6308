package java6308;

import java6308.lesson07.CreateNewFile6308;
import java6308.lesson07.ListFile6308;
import java6308.nio2.NIO2Dir6308;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class shiyan6308Controller {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    public void initialize() {
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new CreateNewFile6308().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new ListFile6308().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new NIO2Dir6308().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    new NIO2Dir6308().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //Lambda
        button1.setOnAction(ActionEvent -> {
            try {
                new CreateNewFile6308().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        button2.setOnAction(ActionEvent -> {
            try {
                new ListFile6308().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        button3.setOnAction(ActionEvent -> {
            try {
                new NIO2Dir6308().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        button4.setOnAction(ActionEvent->{
                try {
                    new NIO2Dir6308().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }

        });


    }

}
