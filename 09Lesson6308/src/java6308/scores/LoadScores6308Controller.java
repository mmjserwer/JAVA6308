package java6308.scores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LoadScores6308Controller {

    @FXML
    private Label lblFilename;

    @FXML
    private TableView<Score6308> tvScores;

    @FXML
    private TableColumn<Score6308, String> colName;

    @FXML
    private TableColumn<Score6308, Integer> colChinese;

    @FXML
    private TableColumn<Score6308, Integer> colMath;

    @FXML
    private TableColumn<Score6308, Integer> colEnglish;

    @FXML
    private TableColumn<Score6308,Integer> colSum;
    @FXML
    private void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colChinese.setCellValueFactory(new PropertyValueFactory<>("chinese"));
        colMath.setCellValueFactory(new PropertyValueFactory<>("math"));
        colEnglish.setCellValueFactory(new PropertyValueFactory<>("english"));
        colSum.setCellValueFactory(new PropertyValueFactory<>("Sum"));
    }

    @FXML
    void openFile(ActionEvent event) {

    }

}
