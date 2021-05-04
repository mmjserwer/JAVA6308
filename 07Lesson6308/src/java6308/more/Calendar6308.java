package java6308.more;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class Calendar6308 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url=getClass().getResource("Calendar6308View.fxml");
        Parent root= FXMLLoader.load(url);
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("显示日历");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
