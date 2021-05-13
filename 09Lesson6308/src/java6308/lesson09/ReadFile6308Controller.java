package java6308.lesson09;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class ReadFile6308Controller {

    @FXML
    private TextField tfFilename;

    @FXML
    private TextArea taText;

    @FXML
    void readFile(ActionEvent event) throws Exception {
        taText.setText("");//清空之前显示
        File file = new File(tfFilename.getText());
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(tfFilename.getText()))) {
                String line = "";
                String data;
                while ((data=br.readLine())!=null) {
                    line=line+data+"\r\n";
                }
                taText.setText(line);
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
        alert.setContentText("源文件不存在");
        alert.show();
    }

}
