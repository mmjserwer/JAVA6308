package java6308.lesson14;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TextClient6308 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("127.0.0.1", 10000);
        Scanner scan = new Scanner(s.getInputStream());
        PrintStream ps = new PrintStream(s.getOutputStream());
        while (scan.hasNext()) {
            if (scan.next().equals("stop")) {
                break;
            } else {
                ps.println(sc.nextLine());
                ps.flush();
            }
        }
        s.close();
    }
}
