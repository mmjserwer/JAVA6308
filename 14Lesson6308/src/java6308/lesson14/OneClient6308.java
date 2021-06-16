package java6308.lesson14;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class OneClient6308 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端");
        Scanner sc = new Scanner(System.in);
        FileInputStream fis = new FileInputStream("config/oneClient6308.properties");
        Properties properties = new Properties();
        properties.load(fis);
        String ip = properties.getProperty("ip");
        String port = properties.getProperty("port");
        Socket socket = new Socket(ip, Integer.parseInt(port));
        Scanner scan = new Scanner(socket.getInputStream());
        PrintStream ps = new PrintStream(socket.getOutputStream());
        System.out.println("连接:"+ip+":"+port);
        String answer=null;
        while(true){
            answer=scan.nextLine().trim();
            if(answer.equals("再见")){
                System.out.println(port+":"+answer);
                break;
            }
            System.out.print("请输入问题：");
            String s = sc.nextLine();
            ps.println(s);
            System.out.println(port+":"+answer);
        }
        ps.close();
        scan.close();
        socket.close();
    }
}
