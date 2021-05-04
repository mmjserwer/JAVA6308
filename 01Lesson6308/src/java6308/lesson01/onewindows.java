package java6308.lesson01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.*;
public class onewindows  extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage){
        VBox root=new VBox();
        Button button = new Button("JavaFX窗口");
        root.getChildren().add(button);
        root.setAlignment(Pos.CENTER);
        Scene scene=new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("第一个窗口");
        primaryStage.show();
    }
}
