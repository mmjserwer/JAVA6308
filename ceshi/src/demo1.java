import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class demo1 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("从键盘输入文件名:");
        String s=sc.nextLine();
        File file=null;
        file = new File(s);
        try(PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println("211906308陈思杰");
            printWriter.println(LocalDateTime.now());
            System.out.println("写入成功");
        }catch (Exception e){
            System.out.println("写入失败");
            e.printStackTrace();
        }
    }
}
