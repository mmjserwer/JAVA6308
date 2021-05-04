package java6308.newdate;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;


public class MothersDay6308 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url=getClass().getResource("MothersDay6308View.fxml");
        VBox root= FXMLLoader.load(url);
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("母亲节");
        primaryStage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
