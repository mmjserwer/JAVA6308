package java6308.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.stream.Stream;

public class Bank6308Controller {
    static Object obj = new Object();
    private static BankAccount6308 account;

    public Bank6308Controller(BankAccount6308 account) {
        this.account = account;
    }


    @FXML
    private TextField tfBankID;//银行账号id

    @FXML
    private TextField tfBalance0;//初始余额

    @FXML
    private Label lblErrMsg;//位于初始余额下方的位置：作用未知

    @FXML
    private TextArea taMoney;//输入金额

    @FXML
    private Label lblBalance;//剩余金额

    @FXML
    private TextArea taResult;//每次线程运行

    @FXML
    void start6308(ActionEvent event) {
        account = new BankAccount6308(tfBankID.getText(), Double.valueOf(tfBalance0.getText()));
        String s = taMoney.getText();
        String[] split = s.split("\n");

    }

    private void run6308() {
        String name = Thread.currentThread().getName();
        String action = "";
        double money = 0, b = 0;


        b = account.getBalance() + money;
        System.out.println(name + ":" + action + Math.abs(money));
        account.setBalance(b);


    }
}


