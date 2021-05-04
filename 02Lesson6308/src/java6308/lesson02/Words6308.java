package java6308.lesson02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Arrays;

public class Words6308 extends Application {
    private Label label;
    private Label lblText;
    private Label  lblPrint;
    private TextField tfText;
    public void start(Stage primaryStage) {
        label = new Label("211906308 陈思杰");
        BorderStroke bs = new BorderStroke(Paint.valueOf("#8FBC8F")//边框的颜色
                , BorderStrokeStyle.DOTTED//边框的样式
                , new CornerRadii(10)//边框四个角的圆角
                , new BorderWidths(3));//边框的宽度
        label.setBorder(new Border(bs));//设置边框
        label.setPadding(new Insets(10));//设置边距

        //水平排列的两个控件，用于输入
        HBox hText = new HBox(10);
        lblText = new Label("输入单词：");
        tfText = new TextField();
        tfText.setPromptText("用空格分隔的字符串");//文本无内容时显示的提示信息
        hText.getChildren().addAll(lblText, tfText);
        hText.setAlignment(Pos.CENTER_LEFT);//两个控件的对齐方式

        VBox root = new VBox(20);//节点之间的垂直间距20

        Button button = new Button("提取单词");

        lblPrint = new Label();//显示排序结果

        root.getChildren().addAll(label, hText, button, lblPrint);
        root.setPadding(new Insets(20.0));//设置根节点的边距
        root.setAlignment(Pos.TOP_CENTER);//根节点中各节点的对齐方式
        root.setStyle("-fx-font-size:20");//用CSS样式设置容器中所有节点的字体大小

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("提取三个字符的单词");
        primaryStage.show();

        //EventHandler<ActionEvent> listener = new MyEventHandler();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String s = tfText.getText();//传入字符串
                String strArry[]=s.split("[, ]");//分割字符串
                int num[]=new int[strArry.length];
                for(int i=0;i<num.length;i++){
                    num[i]=strArry[i].length();
                }
                StringBuilder aa=new StringBuilder();
                aa.append("三个字符的单词：");
                for(int i=0;i<num.length;i++){
                    if(num[i]==3) {
                        aa.append(strArry[i]).append(" ");
                    }
                }
                lblPrint.setText(aa.toString().trim());
            }
        });
    }

    /*class MyEventHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event){

            String s = tfText.getText();
            String strArry[]=s.split("[, ]");
            int num[]=new int[strArry.length];
            for(int i=0;i<num.length;i++){
                num[i]=strArry[i].length();
            }
            StringBuilder aa=new StringBuilder();
            aa.append("三个字符的单词：");
            for(int i=0;i<num.length;i++){
                if(num[i]==3) {
                    aa.append(strArry[i]).append(" ");
                }
            }
            lblPrint.setText(aa.toString().trim());
        }
    }*/

    //启动fx
    public static void main(String[] args) {
        launch(args);
    }
}