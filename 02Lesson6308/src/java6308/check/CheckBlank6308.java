package java6308.check;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class CheckBlank6308 extends Application {
    public void start(Stage primaryStage) {

        //Top
        Label lblStudent = new Label("211906308陈思杰");
        //【注意】多行代码的书写规范
        BorderStroke bs = new BorderStroke(Paint.valueOf("#8FBC8F")
                , BorderStrokeStyle.DOTTED
                , new CornerRadii(10)
                , new BorderWidths(3));
        lblStudent.setBorder(new Border(bs));
        lblStudent.setPadding(new Insets(10));

        //Left
        VBox vRadio = new VBox(30);
        RadioButton rb1 = new RadioButton("第一题");
        RadioButton rb2 = new RadioButton("第二题");
        RadioButton rb3 = new RadioButton("第三题");
        RadioButton rb4 = new RadioButton("第四题");
        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        rb4.setToggleGroup(tg);
        vRadio.getChildren().addAll(rb1, rb2, rb3, rb4);
        vRadio.setAlignment(Pos.CENTER);
        vRadio.setPadding(new Insets(10));

        //Center
        TextArea taTitle = new TextArea();
        taTitle.setEditable(false);

        HBox hInput = new HBox(10);
        Label lblInput = new Label("输入：");
        TextField tfInput = new TextField();
        tfInput.setPromptText("输入被分析的字符串");
        hInput.getChildren().addAll(lblInput, tfInput);
        hInput.setAlignment(Pos.CENTER_LEFT);

        HBox hRegex = new HBox(10);
        Label lblRegex = new Label("正则表达式：");
        TextField tfRegex = new TextField();
        hRegex.getChildren().addAll(lblRegex, tfRegex);
        hRegex.setAlignment(Pos.CENTER_LEFT);

        Button button = new Button("检验");

        VBox vCenter = new VBox(20);
        vCenter.getChildren().addAll(taTitle, hInput, hRegex, button);
        vCenter.setPadding(new Insets(20.0));
        vCenter.setAlignment(Pos.TOP_CENTER);
        VBox.setVgrow(taTitle, Priority.ALWAYS);
        HBox.setHgrow(tfInput, Priority.ALWAYS);
        HBox.setHgrow(tfRegex, Priority.ALWAYS);

        //Bottom
        Label lblPrint = new Label();

        BorderPane root = new BorderPane();
        root.setTop(lblStudent);
        root.setLeft(vRadio);
        root.setBottom(lblPrint);
        root.setCenter(vCenter);
        root.setPadding(new Insets(10));
        BorderPane.setAlignment(lblStudent, Pos.CENTER);
        BorderPane.setAlignment(lblPrint, Pos.CENTER);

        root.setStyle("-fx-font-size:20");//用CSS样式设置容器中所有节点的字体大小
        rb1.setSelected(true);

        Scene scene = new Scene(root, 800, 700);

        primaryStage.setScene(scene);
        primaryStage.setTitle("检验填空题");
        primaryStage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {




            }
        });

    }


    //启动fx
    public static void main(String[] args) {
        launch(args);
    }

}
