import java.io.*;

public class demo {
    public static void main(String[] args) throws IOException {
        System.out.println(copyFile("a.txt","new.txt"));
    }
    public static long copyFile(String name1, String name2) throws IOException {
        InputStream is=new FileInputStream(name1);
        OutputStream os=new FileOutputStream(name2);
        byte[]datas=new byte[8192];
        int len;
        int size=0;
        while((len=is.read(datas))!=-1){
            os.write(datas);
            size+=datas.length;
        }
        is.close();
        os.close();
        return size;
    }
    //【错误1】
    //行号11
    //缺少返回复制的字节数

    //【错误2】
    //行号5
    //缺少定义一个累加字节数的long类型

    //【错误3】
    //行号7
    //缺少累加读到的字节数-->size
}
