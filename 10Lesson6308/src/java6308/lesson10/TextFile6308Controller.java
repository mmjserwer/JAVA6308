package java6308.lesson10;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Comparator;
import java.util.Scanner;

public class TextFile6308Controller {

    @FXML
    private Label lblSource;//

    @FXML
    private Label lblTarget;//

    @FXML
    private TextArea taText;//


    @FXML
    void copyFile(ActionEvent event) throws IOException {

        File file = new File(lblSource.getText());
        File file1 = new File(lblTarget.getText());
        try (Scanner sc = new Scanner(file);PrintWriter printWriter = new PrintWriter(new FileOutputStream(file1));) {
            while(sc.hasNextLine()){
                printWriter.println(sc.nextLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void selectSource(ActionEvent event) {
        lblSource.setText("");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("请选择学生文件");
        fileChooser.setInitialDirectory(new File("."));//初始目录
        //
        FileChooser.ExtensionFilter filter1 = new FileChooser.ExtensionFilter("文本文件(*.txt)", "*.txt");
        FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("所有(*.*)", "*.*");
        //
        fileChooser.getExtensionFilters().addAll(filter1, filter2);
        //
        File file = fileChooser.showOpenDialog(new Stage());
        //
        if (file == null) {
            attion();
        }
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = "";
                String data;//
                while ((data = br.readLine()) != null) {
                    line = line + data + "\r\n";
                }
                //
                taText.setText(line);
                lblSource.setText(file.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            attion();
        }

    }

    @FXML
    void selectTarget(ActionEvent event) {
        lblTarget.setText("");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("请选择学生文件");
        fileChooser.setInitialDirectory(new File("."));//初始目录
        //
        FileChooser.ExtensionFilter filter1 = new FileChooser.ExtensionFilter("文本文件(*.txt)", "*.txt");
        FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("所有(*.*)", "*.*");
        //
        fileChooser.getExtensionFilters().addAll(filter1, filter2);
        //
        File file = fileChooser.showOpenDialog(new Stage());
        //
        if (file == null) {
            attion();
        }
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = "";
                String data;//
                while ((data = br.readLine()) != null) {
                    line = line + data + "\r\n";
                }
                //
                lblTarget.setText(file.getAbsolutePath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
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
