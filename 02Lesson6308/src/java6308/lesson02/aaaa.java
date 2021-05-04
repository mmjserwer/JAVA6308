package java6308.lesson02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aaaa extends Application {
    private TextField tfRegex;
    private TextArea taInput;
    private ListView<String> lvPrint;
    private Button button;
    //启动fx
    public static void main(String []args){
        launch(args);
    }

    public void start(Stage primaryStage){
        Parent root=getRoot();
        Scene scene=new Scene(getRoot());
        primaryStage.setScene(scene);
        primaryStage.show();
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str=taInput.getText();//需要验证的字符串
                String regex= tfRegex.getText();//正则表达式
                String arry[]=str.split(",");
                for(int i=0;i< arry.length;i++) {
                    Pattern p=Pattern.compile(regex);
                    Matcher m=p.matcher(arry[i]);
                    boolean flag=m.find();
                    lvPrint.getItems().add(arry[i]+":"+flag);//通过这个来输出到界面
                }
            }
        });


    }


    private Parent getRoot() {
        //显示每个人的学号和姓名
        Label lblStudent = new Label("填写自己的学号和姓名");
        BorderStroke bs = new BorderStroke(Paint.valueOf("#8FBC8F"),//边框的颜色
                BorderStrokeStyle.DOTTED,//边框的样式
                new CornerRadii(10),//边框四个角的圆角
                new BorderWidths(3));//边框的宽度
        lblStudent.setBorder(new Border(bs));//设置边框
        lblStudent.setPadding(new Insets(10));//设置边距

        //输入正则表达式的两个控件用水平排列
        HBox hRegex = new HBox(10);
        Label lblRegex = new Label("正则表达式：");
        TextField tfRegex = new TextField();
        hRegex.getChildren().addAll(lblRegex, tfRegex);//添加两个控件
        hRegex.setAlignment(Pos.CENTER_LEFT);//垂直居中，水平靠左
        HBox.setHgrow(tfRegex, Priority.ALWAYS);//文本框的宽度填满剩余空间

        Label lblInput = new Label("输入要检验的一组字符串（用逗号分隔）");
        //多行文本框，输入一组要验证的字符串
        TextArea taInput = new TextArea();
        taInput.setPrefRowCount(4);//4行
        taInput.setPrefColumnCount(20);//20列
        taInput.setWrapText(true);//允许自动换行

        Button button = new Button("验证字符串是否符合正则表达式");

        //用于输入的控件采用垂直排列
        VBox vInput = new VBox(20);
        //添加子节点
        vInput.getChildren().addAll(hRegex, lblInput, taInput, button);
        vInput.setPadding(new Insets(20.0));//设置边距
        vInput.setAlignment(Pos.CENTER);//对齐方式

        //列表显示验证结果
        ListView<String> lvPrint = new ListView<>();
        lvPrint.getItems().add("显示验证结果");

        //水平排列：左边输入，右边显示结果
        HBox hBox = new HBox();
        hBox.getChildren().addAll(vInput, lvPrint);

        //垂直排列的根节点
        VBox root = new VBox(20);//节点之间的垂直间距20
        //为根节点添加子节点
        root.getChildren().addAll(lblStudent, hBox);
        root.setPadding(new Insets(20.0));//设置根节点的边距
        root.setAlignment(Pos.TOP_CENTER);//根节点中各节点的对齐方式

        root.setStyle("-fx-font-size:20");//用CSS样式设置容器中所有节点的字体大小
        return root;
    }
}
