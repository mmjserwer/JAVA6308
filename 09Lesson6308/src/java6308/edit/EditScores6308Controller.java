package java6308.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class EditScores6308Controller {

    @FXML
    private Label lblFilename;

    @FXML
    private TableView<?> tvScores;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colChinese;

    @FXML
    private TableColumn<?, ?> colMath;

    @FXML
    private TableColumn<?, ?> colEnglish;

    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    void openFile(ActionEvent event) {

    }

    @FXML
    void saveFile(ActionEvent event) {

    }

}