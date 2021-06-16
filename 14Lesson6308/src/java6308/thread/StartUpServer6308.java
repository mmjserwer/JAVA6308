package java6308.thread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class StartUpServer6308 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        ServerSocket ss = new ServerSocket(18889);
        Socket s = ss.accept();//
        //启动fx窗口
        Thread thread = new Thread();
        thread.start();
        Message6308.main(args);

        /*Scanner scan = new Scanner(s.getInputStream());
        PrintStream ps = new PrintStream(s.getOutputStream());
        ps.println("欢迎致电深夜有声音，我是主持人陈思杰，很高兴为你服务");
        String prolbem = null;
        while (true) {
            prolbem = scan.next().trim();
            if (prolbem.equals("谢谢")) {
                ps.println("再见");
                System.out.println("结束：" + client);
                break;
            }
            System.out.println("问" + i++ + prolbem);
            System.out.println("请输入答案：");
            String s1 = sc.nextLine();
            ps.println(s1);
            ps.flush();
        }
        ps.close();
        scan.close();*/
        s.close();
    }
}
