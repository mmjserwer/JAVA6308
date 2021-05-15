package java6308.scores;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class LoadScores6308Controller {

    @FXML
    private Label lblFilename;//

    @FXML
    private TableView<Score6308> tvScores;//

    @FXML
    private TableColumn<Score6308, String> colName;//

    @FXML
    private TableColumn<Score6308, Integer> colChinese;//

    @FXML
    private TableColumn<Score6308, Integer> colMath;//

    @FXML
    private TableColumn<Score6308, Integer> colEnglish;//

    @FXML
    private TableColumn<Score6308,Integer> colSum;//
    ObservableList<Score6308> items ;//
    List<Score6308> list=new ArrayList<>();//
    @FXML
    //初始化
    private void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colChinese.setCellValueFactory(new PropertyValueFactory<>("chinese"));
        colMath.setCellValueFactory(new PropertyValueFactory<>("math"));
        colEnglish.setCellValueFactory(new PropertyValueFactory<>("english"));
        colSum.setCellValueFactory(new PropertyValueFactory<>("sum"));
        lblFilename.setText("");
    }

    @FXML
    void openFile(ActionEvent event) {
        items=tvScores.getItems();//
        items.clear();//
        list.clear();//
        //
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("请选择学生文件");
        fileChooser.setInitialDirectory(new File("."));//初始目录
        //
        FileChooser.ExtensionFilter filter1 = new FileChooser.ExtensionFilter("文本文件(*.txt)", "*.txt");
        FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("所有(*.*)", "*.*");
        //
        fileChooser.getExtensionFilters().addAll(filter1, filter2);
        //
        File file=fileChooser.showOpenDialog(new Stage());
        //
        if(file==null){
            attion();
        }
        //
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String data;//
                while ((data=br.readLine())!=null) {
                    if(data.contains(",")){//
                        Score6308 myScore6308=new Score6308();
                        String[] split = data.split(",");
                        myScore6308.setName(split[0]);
                        myScore6308.setChinese(Integer.parseInt(split[1]));
                        myScore6308.setMath(Integer.parseInt(split[2]));
                        myScore6308.setEnglish(Integer.parseInt(split[3]));
                        myScore6308.setSum(myScore6308.getSum());
                        list.add(myScore6308);
                    }
                }
                //
                list.sort(Comparator.comparing(Score6308::getSum).thenComparing(Score6308::getMath).reversed());
                items.addAll(list);
                lblFilename.setText(list.size()+"条学生成绩数据:"+file.getAbsolutePath());
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        } else {
            attion();
        }

    }
    void attion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("读文本文件");
        alert.setHeaderText("请注意");
        alert.setContentText("错误");
        alert.show();
    }

}
