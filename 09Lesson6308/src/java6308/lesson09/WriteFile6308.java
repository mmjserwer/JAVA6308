package java6308.lesson09;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.Scanner;

//Juit:单元测试,导入jar包
public class WriteFile6308 implements AutoCloseable {

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.print("请输入文件名：");
        String filename = input.nextLine();
        // 调用write6308()向文件中输出字符串，并返回字节数
        // 在控制台上输出向文件中写入的字节数
        // 步骤1：确定输出的文件（目的地）
        // 如果filename中包含路径，必须确保路径已存在
        File file = new File(filename);
        try{
            System.out.println("已向文件中写入:" +write6308(file.getAbsolutePath())+ "字节");
        } catch (Exception e){
            System.out.println("路径不存在");
        }

    }
    private static long write6308(String filename) throws IOException{
        //【注意】请使用try…catch…finally进行异常处理，并释放资源
        // 步骤2：创建指向文件的字符输出流
        // 步骤3：写数据
        // 输入一行写一行
        // 步骤4：关闭
        // 返回文件的字节数
        //处理写入数据的异常
        long count=0;
        Scanner input = new Scanner(System.in);
        BufferedWriter bufferedWriter = null;
        try{
            bufferedWriter=new BufferedWriter(new FileWriter(filename,true));
            System.out.println("请逐行输入要写入文件的内容，直到输入end结束(end不区分大小写)");
            String data=input.nextLine();
            while(!data.toLowerCase().equals("end")){
                byte[] bytes = data.getBytes();
                count+=bytes.length;
                bufferedWriter.write(data);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                data=input.nextLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return count;
    }
    @Override
    public void close() throws Exception {

    }

}
