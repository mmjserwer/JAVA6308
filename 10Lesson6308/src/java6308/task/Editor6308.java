package java6308.task;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Editor6308 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = getClass().getResource("Editor6308View.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root=null;
        try{
            root=loader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("文本编辑器");
        primaryStage.show();

        Editor6308Controller controller = loader.getController();
        controller.setCloseRequest(primaryStage);
    }
}
