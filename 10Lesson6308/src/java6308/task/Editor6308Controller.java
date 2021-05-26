package java6308.task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Editor6308Controller {

    @FXML
    private TextField tfFilename;

    @FXML
    private TextArea taText;

    @FXML
    void openFile(ActionEvent event) {



    }

    @FXML
    void saveAsFile(ActionEvent event) {

    }

    @FXML
    void saveFile(ActionEvent event) {

    }

    public void setCloseRequest(Stage primaryStage) {
        primaryStage.setOnCloseRequest(this::inclose);
    }

    private void inclose(WindowEvent windowEvent) {

    }
}