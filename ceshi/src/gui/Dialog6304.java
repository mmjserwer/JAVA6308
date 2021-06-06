package java6304.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Dialog6304 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        URL url= getClass().getResource("Dialog6304View.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = null;
        try {
            root=loader.load();
        }catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("测试");
        primaryStage.show();

    }
}
