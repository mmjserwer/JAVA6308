package java6308.scores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LoadScores6308Controller {

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
    private TableColumn<?, ?> colSum;

    @FXML
    void openFile(ActionEvent event) {

    }

}
