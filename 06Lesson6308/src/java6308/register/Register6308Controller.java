package java6308.register;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.*;

public class Register6308Controller {

    @FXML
    private TextField tfName;//用户名

    @FXML
    private PasswordField pf1;//第一次密码

    @FXML
    private PasswordField pf2;//第二次密码

    @FXML
    private TextField tfPhone;//手机号

    @FXML
    private Label lblName;//用户名出现问题的提示

    @FXML
    private Label lblPW1;//第一次密码出现问题的提示

    @FXML
    private Label lblPW2;//第二次密码出现问题的提示

    @FXML
    private Label lblPhone;//手机号出现问题的提示

    @FXML
    private Button btnOk;//注册按钮

    @FXML
    private ListView<User6308> lvUsers;//已经注册列表的显示
    ObservableList<User6308> items;
    Set<User6308> set=new HashSet<User6308>();

    //用户名输入 两次密码输入 手机号输入的监听
    @FXML
    void enterKey(ActionEvent event) {
        tfName.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num=0;
                //没有输入
                if(tfName.getText().length()==0){
                    lblName.setVisible(true);
                    num=1;
                }
                //判断用户名的合法性和唯一
                for (User6308 me : set) {
                    if (me.getName().toLowerCase().equals(tfName.getText().toLowerCase())) {
                        num=1;
                        lblName.setVisible(true);
                    }
                }
                if(num==0){
                    lblName.setVisible(false);
                }
            }
        });

        pf1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //判断第一次密码的合法性
                if (!pf1.getText().matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}")) {
                    lblPW1.setVisible(true);
                }else {
                    lblPW1.setVisible(false);
                }
            }
        });

        pf2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //判断第二次密码的合法性并且和第一次密码一样
                if ((pf2.getText().matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}")) && (pf1.getText().equals(pf2.getText()))) {
                    lblPW2.setVisible(false);
                } else {
                    lblPW2.setVisible(true);
                }
            }
        });

        tfPhone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //判断手机号的合法性
                if (!tfPhone.getText().matches("1[3578]\\d{9}")) {
                    lblPhone.setVisible(true);
                }else{
                    lblPhone.setVisible(false);
                }
            }
        });

    }

    //取消按钮的监听
    @FXML
    void noClick(ActionEvent event) {
        //将所有出现的提醒隐藏 并清空内容
        lblPhone.setVisible(false);
        lblPW2.setVisible(false);
        lblPW1.setVisible(false);
        lblName.setVisible(false);
        tfName.setText("");
        tfPhone.setText("");
        pf1.setText("");
        pf2.setText("");
    }

    //注册按钮的监听
    @FXML
    void okClick(ActionEvent event) throws Exception{
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Boolean temp = true;

                if (set!=null) {
                    for (User6308 me : set) {
                        if (tfName.getText().toLowerCase().equals(me.name.toLowerCase())) {
                            temp = false;
                            ifalter();
                        }
                    }
                }
                if (temp) {
                    if(tfName.getText().length()!=0&&(pf1.getText().equals(pf2.getText()))&&tfPhone.getText().matches("1[3578]\\d{9}")){
                        set.add(new User6308(tfName.getText(), pf2.getText(), tfPhone.getText()));
                        items = lvUsers.getItems();
                        items.clear();
                        items.addAll(set);
                    }
                }
            }
        });
    }

    public static class User6308 {
        private String name;
        private String password;
        private String phone;

        public User6308() {
        }

        public User6308(String name, String password, String phone) {
            this.name = name;
            this.password = password;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "姓名：" + name + ",密码：" + password + ",手机号:" + phone;
        }

    }

   void ifalter(){
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("用户注册V1.0｜集合版");
       alert.setHeaderText("请注意");
       alert.setContentText("该用户名存在(不区分大小写)");
       alert.show();

    }

}
