package java6308.lesson01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventDemo extends Application {
    private Label label;
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox( 30);
        Button button = new Button( "点我");
        label = new Label( "Hello");
        root.getChildren().addAll(label, button);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,300,200);
        primaryStage.setScene(scene) ;
        primaryStage.setTitle("事件处理");
        primaryStage.show();

        EventHandler<ActionEvent> listener = new MyEventHandler();
        button.setOnAction(listener);
    }
    class MyEventHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
            if(label.getText().equals("Hello")){
                label.setText("你好");
            }
            else{
                label.setText("Hello");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
