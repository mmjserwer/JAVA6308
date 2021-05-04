package java6308.group;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskGroupDemo6308 {
    public static void main(String[] args) throws FileNotFoundException {
        TaskGroups6308 stuList = new TaskGroups6308();
        try {
            stuList.getStudentList();//获取学生姓名学号和人数
        } catch (Exception e) {
            e.printStackTrace();
        }
        stuList.getGroup();//获取每组学生的人数
        stuList.printList();//输出每组人数及其姓名
    }
}
