package java6308.nio2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class NIO2Dir6308 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("NIO2Dir6308View.fxml");
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("NIO2与TableView显示目录内容");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
