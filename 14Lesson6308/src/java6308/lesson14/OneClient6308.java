package java6308.lesson14;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Scanner;

public class OneClient6308 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileInputStream fis = new FileInputStream("config/oneClient6308.properties");
        Properties properties = new Properties();
        properties.load(fis);

    }
}
