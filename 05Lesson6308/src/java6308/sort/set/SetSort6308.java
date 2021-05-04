package java6308.sort.set;

import java.util.*;

public class SetSort6308 {
    public static void main(String[] args) {
        Collection<Course6308> list = new TreeSet<Course6308>();
        list.add(new Course6308("操作系统", "2下", "B001", 3, 90));
        list.add(new Course6308("Python程序基础", "1下", "B002", 2, 85));
        list.add(new Course6308("高等数学", "1下", "0002", 2, 85));
        list.add(new Course6308("Java程序高级开发", "3上", "C001", 2, 83));
        list.add(new Course6308("大学英语", "1上", "0001", 3, 80));
        list.add(new Course6308("面向对象程序设计", "2上", "A002", 3, 78));
        list.add(new Course6308("C程序设计基础", "1上", "A001", 4, 80));
        list.add(new Course6308("数据库原理", "2上", "A003", 3, 78));
        list.add(new Course6308("网络基础", "3上", "B003", 3, 75));
        list.add(new Course6308("软件工程与UML", "3下", "C002", 3, 75));

        System.out.println("按成绩降序");
        for (Course6308 a : list) {
            System.out.println(a);
        }
        System.out.println();

        System.out.println("按学期升序");
        Collection<Course6308> list1 = new TreeSet<Course6308>(new Comparator<Course6308>() {
            @Override
            public int compare(Course6308 o1, Course6308 o2) {
                //获取开课学期的第一个数字
                int sum1 = o1.getTerm().charAt(0);
                int sum2 = o2.getTerm().charAt(0);
                //当开课学期的第一个数字相同时 判断第二个字符 那个字符大 那个就加上1
                if (sum1 == sum2) {
                    String c = String.valueOf(o1.getTerm().charAt(1));
                    String d = String.valueOf(o2.getTerm().charAt(1));
                    if (c.equals("上")) {
                        if (d.equals("下")) {
                            sum2++;
                        }
                    }
                    if (c.equals("下")) {
                        if (d.equals("上")) {
                            sum1++;
                        }
                    }
                }
                int s1 = sum1 - sum2;
                int s2=s1==0? o1.getScore()-o2.getScore():s1;
                int s3=s2==0? o1.getCredit()-o2.getCredit():s2;
                int s4=s3==0? o1.getName().compareTo(o2.getName()):s3;
                return s4;
            }
        });
        list1.addAll(list);
        for (Course6308 a : list1) {
            System.out.println(a);
        }
        System.out.println();

        System.out.println("按学分升序");
        TreeSet<Course6308>list2 =new TreeSet<Course6308>(new SorterByCredit6308());
        list2.addAll(list);
        for (Course6308 a : list2) {
            System.out.println(a);
        }
        System.out.println();


        System.out.println("按学期、学分多关键字排序（升序）");
        TreeSet<Course6308> list3 = new TreeSet<Course6308>(Course6308::compareTwo);
        list3.addAll(list);

        for (Course6308 a : list3) {
            System.out.println(a);
        }
    }

    private static void compareff(Collection<Course6308> list4) {
        list4.stream().sorted(Course6308::compareTwo);
    }
}
