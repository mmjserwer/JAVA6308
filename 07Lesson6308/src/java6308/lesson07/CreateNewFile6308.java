package java6308.lesson07;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class CreateNewFile6308 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("CreateNewFile6308View.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("创建新文件");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
