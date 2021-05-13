package java6308.lesson09;

import java.io.*;
import java.util.Scanner;


public class CopyFile6308 implements AutoCloseable {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入要拷贝的源文件名：");
        String source = input.nextLine();
        System.out.print("请输入目标文件名：");
        String target = input.nextLine();
        //调用checkFile6308()方法检查两个文件名是否可用
        //调用System.currentTimeMillis()记下开始时间-->beginTime
        long beginTime = System.currentTimeMillis();
        long num=copy6308(source, target);
        long endTime=System.currentTimeMillis();
        //如果两个文件名可用，调用copy6308()方法完成文件拷贝，并返回文件的字节数
        if (checkFile6308(source, target)) {
            System.out.println("拷贝"+num+"字节，用时："+(endTime-beginTime)+"毫秒");
        } else {
            System.out.println("拷贝失败");
        }
        //调用System.currentTimeMillis()得到当前时间，计算拷贝文件所用的时长
        //输出拷贝文件的字节数和用时
    }

    private static boolean checkFile6308(String sourceName, String targetName) throws Exception {
        //确保源文件已经存在
        //调用File的getParentFile()，得到目标文件名所包含的路径
        //判断目标路径是否已经存在，如果不存在，创建
        File file = new File(sourceName);
        if (!file.exists()) {
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                if (!parent.mkdirs()) {
                    return false;
                }
            }
            return false;
        }
        File file1 = new File(targetName);
        if (!file1.exists()) {
            File parent = file1.getParentFile();
            if (parent != null && !parent.exists()) {
                if (!parent.mkdirs()) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    private static long copy6308(String sourceName, String targetName) throws IOException {
        //针对源文件，创建带缓冲的输入流
        //针对目标文件，创建带缓冲的输出流
        // 定义一个字节数组，作为缓冲区-->buff
        //循环执行下列步骤，直到文件结束
        //1）从输入流中读取数据存入buff
        //2）再把buff中的内容写入到输出流
        //3）累加读到的字节数-->size
        //关闭输入流和输出流
        //返回字节数
        long size=0;
        File file = new File(sourceName);
        File file1 = new File(targetName);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file1))) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
                size+=len;
            }
        }
        return size;
    }

    @Override
    public void close() throws Exception {

    }
}