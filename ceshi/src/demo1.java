import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class demo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("new.txt");
        FileOutputStream out = new FileOutputStream(file);
        String str="aaaaaa\r\n";
        byte[] data = str.getBytes(StandardCharsets.UTF_8);
        out.write(data);
        String a="S";
        /*out.write(a);*/
        String now="aaaaaa"+ LocalDateTime.now();
        out.write(now.getBytes());


    }
}
