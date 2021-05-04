package java6308.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class NIO2NewFile6308 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Path path = Paths.get(s);
        try {
            if (!Files.exists(path)) {
                File parent = path.toFile().getParentFile();
                if (parent != null && !parent.exists()) {
                    if (!parent.mkdirs()) {
                        throw new IOException();
                    }
                    System.out.println("创建目录：" + parent);
                }
                Files.createFile(path);
                System.out.println("创建新文件：" + path.toAbsolutePath());
            } else {
                System.out.println("文件已存在");
            }
        }catch (Exception e){
            System.out.println("不能创建目录");
        }
    }
}
