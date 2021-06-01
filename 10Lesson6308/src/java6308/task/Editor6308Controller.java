package java6308.task;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

public class Editor6308Controller {

    private File currentFile;
    private boolean isChange;
    @FXML
    private TextField tfFilename;

    @FXML
    private TextArea taText;

    @FXML
    private  void initialize(){
        taText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                isChange=true;
            }
        });
    }
    @FXML
    void openFile(ActionEvent event) throws FileNotFoundException {
        FileChooser fc=getFileChooser("打开");
        currentFile = fc.showSaveDialog(new Stage());
        if(currentFile!=null){
            tfFilename.setText(currentFile.toString());
            Scanner reader=new Scanner(currentFile);
            String line;
            taText.setText("");
            StringBuilder sBuilder=new StringBuilder();
            while(reader.hasNext()){
                line=reader.nextLine();
                sBuilder.append(line).append("\r\n");
            }
            taText.setText(sBuilder.toString());
            reader.close();
            isChange=false;
        }
    }

    @FXML
    void saveAsFile(ActionEvent event) {
        FileChooser fc=getFileChooser("另存为");
        File asfile = fc.showSaveDialog(new Stage());
        save(asfile);
    }

    @FXML
    void saveFile(ActionEvent event) {
        if(currentFile==null){
            FileChooser fc=getFileChooser("另存为");
            File file = fc.showSaveDialog(new Stage());
            save(file);
        }else {
            save(currentFile);
        }
    }

    public void setCloseRequest(Stage primaryStage) {
        primaryStage.setOnCloseRequest(this::inclose);
    }

    private void inclose(WindowEvent windowEvent) {
        if(isChange) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("文本编辑器关闭提示");
            String title=currentFile==null?"?":("到"+currentFile+"?");
            alert.setHeaderText("是否将未存盘的修改保存？" + title);
            alert.getButtonTypes().setAll(
                    ButtonType.YES,
                    ButtonType.NO,
                    ButtonType.CANCEL
            );
            Optional<ButtonType> type = alert.showAndWait();
            type.ifPresent(new Consumer<ButtonType>() {
                @Override
                public void accept(ButtonType buttonType) {
                    if (buttonType == ButtonType.YES) {
                        new Alert(Alert.AlertType.INFORMATION, "数据已保存").show();
                        saveFile(null);
                    } else if (buttonType == ButtonType.NO) {
                        new Alert(Alert.AlertType.INFORMATION, "不保存数据").show();
                    } else {
                        windowEvent.consume();
                    }
                }
            });
        }
    }
    private void save(File file){
        if(file==null) return;
        try(PrintWriter pw=new PrintWriter(new FileOutputStream(file))){
            pw.print(taText.getText());
            isChange=false;
            currentFile=file;
            tfFilename.setText(currentFile.toString());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private FileChooser getFileChooser(String title){
        FileChooser fc = new FileChooser();
        fc.setTitle(title);
        fc.setInitialDirectory(new File("."));
        fc.getExtensionFilters().addAll(
          new FileChooser.ExtensionFilter("文本文件","*.txt"),
          new FileChooser.ExtensionFilter("Java文件","*.java"),
          new FileChooser.ExtensionFilter("所以","*.*")
        );
        return fc;
    }
}