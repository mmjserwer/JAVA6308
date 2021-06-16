package java6308.lesson14;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TextServer6308 {
    public static void main(String[] args) throws IOException {
        File file = new File("data/text6308.txt");
        ServerSocket ss = new ServerSocket(10000);
        Socket s = ss.accept();
        Scanner scan = new Scanner(s.getInputStream());
        PrintStream ps = new PrintStream(file);
        while(scan.hasNext()){
            System.out.println(scan.next());
            ps.println(scan.next());
            ps.flush();
        }
        ps.close();
        scan.close();
        s.close();
    }
}
