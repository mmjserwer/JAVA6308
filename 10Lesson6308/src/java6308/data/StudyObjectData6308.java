package java6308.data;

import java.io.*;

public class StudyObjectData6308 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeStudent6308();
        readStudent6308();
    }

    private static void writeStudent6308() {
        File file = new File("write" + File.separator + "student6308.dat");
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(new Student6308("陈思杰", 20));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    private static void readStudent6308() throws IOException, ClassNotFoundException {
            File file = new File("write" + File.separator + "student6308.dat");
            if (!file.exists()) {
                System.out.println("文件不存在！");
                return;
            }
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            Object obj = in.readObject();
            System.out.println(obj);
            Student6308 stu = (Student6308) obj;
            System.out.println("姓名=" + stu.getName() + "，年龄=" + stu.getAge());
            in.close();

    }

}
