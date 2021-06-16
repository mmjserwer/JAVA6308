package java6308.lesson14;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class BaseClient6308 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户拨号......");
        Socket socket = new Socket("127.0.0.1",10000);
        PrintStream ps = new PrintStream(socket.getOutputStream());
        ps.println("空调不制冷");
        Scanner scan = new Scanner(socket.getInputStream());
        System.out.println(scan.nextLine());
        scan.close();
        ps.close();
        socket.close();
    }
}
