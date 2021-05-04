package selection;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectionWin6308 extends Application {
    private Label label;
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox( 30);
        Button button = new Button( "选人");
        label = new Label( "随机选人");
        root.getChildren().addAll(label, button);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,300,200);
        primaryStage.setScene(scene) ;
        primaryStage.setTitle("事件处理");
        primaryStage.show();

        EventHandler<ActionEvent> listener = new SelectionWin6308.MyEventHandler();
        button.setOnAction(listener);
    }
    class MyEventHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){
                label.setText("");

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

