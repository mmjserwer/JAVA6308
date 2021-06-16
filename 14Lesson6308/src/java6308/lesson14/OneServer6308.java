package java6308.lesson14;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OneServer6308 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("18888服务平台");
        int i = 1;
        ServerSocket ss = new ServerSocket(18888);

        Socket s = ss.accept();//
        String client = s.getInetAddress().getHostAddress() + ":" + s.getPort() + ",已接入";
        System.out.println(client);
        Scanner scan = new Scanner(s.getInputStream());
        PrintStream ps = new PrintStream(s.getOutputStream());
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
        System.out.println("结束:"+client);
        ps.close();
        scan.close();
        s.close();

    }
}
