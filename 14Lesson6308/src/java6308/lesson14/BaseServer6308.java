package java6308.lesson14;

import java.io.IOException;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class BaseServer6308 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        ServerSocket ss = new ServerSocket(18889);
        System.out.println("等待客户电话.....");
        Socket s = ss.accept();
        System.out.println("客户端："+s.getPort());
        Scanner scan = new Scanner(s.getInputStream());
        PrintStream ps = new PrintStream(s.getOutputStream());
        System.out.println("接听电话...."+scan.nextLine());
        Thread.sleep(1000);
        System.out.println("请按“工号：XXXXXXXX”的格式向客户端发送信息，其中XXXXXXXX用自己的学号和姓名替换");
        String s2 = input.nextLine();
        ps.println("很高兴为您服务.......工号：211906308陈思杰"+s2);
        scan.close();
        ps.close();
        s.close();



    /*String a="";
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            byte[] b=new byte[1024];
            int len;
            while((len=is.read())!=-1){
                a=a+is.read(b,0,len);
            }
            System.out.println(a);
            is.close();
            os.close();*/
    }
}
