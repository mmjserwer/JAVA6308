package java6308.group;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TaskGroups6308 {
    static ArrayList<Student6308> list = new ArrayList<Student6308>();//储存从硬盘中读写的文本
    static ArrayList<Student6308> list1 = new ArrayList<Student6308>();//用于新集合的输出
    static ArrayList<Integer> groupList = new ArrayList<Integer>();//分组集合
    static int xhnum = 0;//循环次数

    /**
     * 获取txt文本的信息
     */
     static void getStudentList() throws Exception {
        Scanner sc = new Scanner(new File("data\\StudentList.txt"));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            list.add(new Student6308(line.split(" ")[1]));
        }
    }

    /**
     * 分组
     */
     static void getGroup() {
        Random random = new Random();
        Integer a = random.nextInt(7 - 5 + 1) + 5;//生成5-7的随机数
        int count = 0;//用于计算元素是否满足条件
        //设置每组人数 当满足条件时跳出循环
        while (count != list.size()) {
            a = random.nextInt(7 - 5 + 1) + 5;//生成5-7的随机数
            count += a;
            groupList.add(a);//将生成的随机数添加的集合内
            if (count > list.size()) {
                groupList.clear();//不满足条件 清空集合元素
                xhnum++;
                count = 0;//初始化
            }
        }
        xhnum++;//记录循环次数
    }


    /**
     * 输出每组信息
     */
    static void printList() {
        System.out.println("班级人数:" + list.size());
        System.out.println("经过循环" + xhnum + "次" + "分成" + groupList.size() + "小组,每个小组人数" + groupList);
        Collections.shuffle(list);//打乱集合内顺序
        int a = 0;//记录每次输入到的位置
        for (int i = 0; i < groupList.size(); i++) {
            for (int j = 0; j < groupList.get(i); j++) {
                list1.add(list.get(a++));//为该组集合添加list文本中的内容
            }
            System.out.println("第" + (i + 1) + "次" + list1 + "，共" + groupList.get(i) + "人");
            list1.clear();//每次输出清空
        }
    }

    /**
     * 学生类
     */
     static class Student6308 {
        private String name;

        public Student6308(String s) {
            name = s;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * 无参构造
     */
    public TaskGroups6308() {
    }
}
