import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        DirectoryChooser directoryChooser=new DirectoryChooser();
        directoryChooser.showDialog(new MyWindow());
    }
    static  class MyWindow extends Window{

    }
}
