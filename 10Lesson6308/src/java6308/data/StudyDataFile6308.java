package java6308.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class StudyDataFile6308 {

  private static String path="data"+File.separator;
  /**
   * 字节数组转换为int
   * 
   * @param
   * @return
   */
  public static int byteArrayToInt6308(byte[] b) {
    return b[3] & 0xFF | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16 | (b[0] & 0xFF) << 24;
  }

  /**
   * int转换成字节数组
   * 
   * @param a
   * @return
   */
  public static byte[] intToByteArray6308(int a) {
    return new byte[] { (byte) ((a >> 24) & 0xFF), (byte) ((a >> 16) & 0xFF), (byte) ((a >> 8) & 0xFF), (byte) (a & 0xFF) };
  }

  public static void main(String[] args) throws Exception {
    //运行1
    /*
    【问题1】dataXXXX.dat的绝对路径是什么？dataXXXX.dat是文本文件吗？

    当前项目下的目录  不是文本文件
    【问题2】请说明writeIntWithByteXXXX()方法是怎样把整型数据保存到文件中的？

    【问题3】请说明readIntWithByteXXXX()方法是怎样从文件中读取整型数据的？
    */
    writeIntWithByte6308();
    readIntWithByte6308();

    //运行2
    /*
    【问题4】writeXXXX()与writeIntWithByteXXXX()具有相同的功能，请比较代码的不同点。
    【问题5】总结读写文件时，分别需要对文件做哪些判断？
    */
    writeData6308();
    readData6308();

    //运行3
    /*
    *【问题6】使用DataOutputStream、DataInputStream有什么好处？
    * */
  }


  public static void writeIntWithByte6308() throws Exception {
    // 步骤1：确定输出的文件（目的地）
    // File.separator表示跨平台的目录分隔符
    File file = new File(path + "data6308.dat");
    // 输出时文件可以不存在，但目录必须存在
    if (!file.getParentFile().exists()) {
      file.getParentFile().mkdirs();
    }
    // 步骤2：创建指向文件的输出流
    OutputStream out = new FileOutputStream(file);
    // 步骤3：写数据
    out.write(intToByteArray6308(2048));
    // 步骤4：关闭
    out.close();
  }

  public static void readIntWithByte6308() throws Exception {
    // 步骤1：确定输入的源文件
    // File.separator表示跨平台的目录分隔符
    File file = new File(path +"data6308.dat");
    // 输入时文件必须存在
    if (!file.exists()) {
      System.out.println("文件不存在！");
      return;
    }
    // 步骤2：创建指向文件的输入流
    InputStream in = new FileInputStream(file);

    // 步骤3：读数据
    byte[] data = new byte[4];
    in.read(data);
    int i = byteArrayToInt6308(data);
    System.out.println(i);

    // 步骤4：关闭流
    in.close();

  }

  public static void writeData6308() throws Exception {
    // 步骤1：确定输出的文件（目的地）
    // File.separator表示跨平台的目录分隔符
    File file = new File(path + "data6308.dat");
    // 输出时文件可以不存在，但目录必须存在
    if (!file.getParentFile().exists()) {
      file.getParentFile().mkdirs();
    }
    // 步骤2：创建指向文件的数据输出流
    DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
    // 步骤3：写数据
    out.writeInt(123);
    // 步骤4：关闭
    out.close();
  }


  public static void readData6308() throws Exception {
    // 步骤1：确定输入的源文件
    // File.separator表示跨平台的目录分隔符
    File file = new File(path + "data6308.dat");
    // 输入时文件必须存在
    if (!file.exists()) {
      System.out.println("文件不存在！");
      return;
    }
    // 步骤2：创建指向文件的数据输入流
    DataInputStream in = new DataInputStream(new FileInputStream(file));

    // 步骤3：读数据
    System.out.println(in.readInt());
    // 步骤4：关闭流
    in.close();

  }

}
