package java6308.data;

import java.io.*;

public class StudyObjectData6308 {
    public static void main(String[] args)  {
        writeStudent6308();

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

}
