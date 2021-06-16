package java6308.thread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class StartUpClient6308 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("127.0.0.1", 18889);

        Thread thread = new Thread();
        thread.start();
        Message6308.main(args);

        Scanner scan = new Scanner(s.getInputStream());
        PrintStream ps = new PrintStream(s.getOutputStream());
        System.out.println("客户端");
        System.out.println("请输入内容：");
        String s1=null;
        s1 = sc.nextLine();
        while (true) {
            if (s1.trim().equals("stop")) {
                break;
            } else {
                ps.println(s1);
                ps.flush();
            }
            s1=sc.nextLine();
        }
        System.out.println(scan.next());
        System.out.println("结束！！！");
        ps.close();
        scan.close();
        s.close();
    }
}
