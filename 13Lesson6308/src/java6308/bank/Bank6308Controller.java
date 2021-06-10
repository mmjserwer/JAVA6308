package java6308.bank;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank6308Controller {

    Object obj = new Object();

    private BankAccount6308 account;

    List<String> list = new ArrayList<>();//用于存放线程数据

    List<Integer> listMoney=new ArrayList<>();//存放存钱数据

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


        account = new BankAccount6308(tfBankID.getText(), Double.parseDouble(tfBalance0.getText()));
        listMoney = getMoney(taMoney.getText());
        for (int i = 1; i <= listMoney.size(); i++) {
            Thread thread = new Thread(this::bank6308, "线程" + i);
            thread.start();

        }
        String t="";
        for(int i=0;i<list.size();i++){
            t=t+list.get(i)+"\n";
        }
        taResult.setText(t);
        System.out.println(listMoney.toString());
        lblBalance.setText(account.getBalance()+"元");

    }

    //获取每次的金额 有效存取款
    public List<Integer> getMoney(String s) {
        String[] split = s.split("\n");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (isNumber(split[i])) {
                list.add(Integer.parseInt(split[i]));
            }
        }
        return list;
    }

    private void bank6308() {
        synchronized (this){
            String name = Thread.currentThread().getName();
            String action = "";
            double money = 0, b = 0;
            int a=0;
            String[] s = name.split("线程");
            a=Integer.parseInt(s[1]);
            a=a-1;
            for(int i=0;i<listMoney.size();i++){
                if(a==i){
                    money=listMoney.get(i);
                }
            }
            if (money >= 0) {
                action = "存款";
            } else {
                action="取款";
            }
            b = account.getBalance() + money;
            if(b<0){
                System.out.println(name + ":" + action + Math.abs(money)+"失败，余额不足("+account.getBalance()+")");
                list.add(name + ":" + action + Math.abs(money)+"失败，余额不足("+account.getBalance()+")");
            }else {
                System.out.println(name + ":" + action + Math.abs(money));
                list.add(name + ":" + action + Math.abs(money));
                account.setBalance(b);
            }

        }


    }

    //判断是否为负数 或者正数
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[-+]?[0-9]+\\.?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}


