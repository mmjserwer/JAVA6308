package java6308.lesson14;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TextServer6308 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端");
        File file = new File("data/text6308.txt");
        ServerSocket ss = new ServerSocket(18889);
        Socket s = ss.accept();
        Scanner scan = new Scanner(s.getInputStream());
        PrintStream ps = new PrintStream(s.getOutputStream());
        PrintStream fps = new PrintStream(file);
        System.out.println("连接成功，等待用户输入");
        ps.println("工号：211906308陈思杰为您服务，请输入你要存的内容(输入stop结束)：");
        String line=null;
        while(true){
            line=line=scan.nextLine();
            System.out.println(line);
            if(line.equals("stop")){
                break;
            }
            fps.println(line);
        }
        ps.println("欢迎下一次存储！！！");
        fps.close();
        ps.close();
        scan.close();
        s.close();
    }
}
