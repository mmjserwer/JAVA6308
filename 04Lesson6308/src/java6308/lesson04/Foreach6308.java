package java6308.lesson04;

import java.util.*;

public class Foreach6308 {
    public static void main(String[] args) {
        //创建两种泛型集合 list 和Collection
        List<Student6308> list = new ArrayList<Student6308>();
        Collection<Student6308> collectionlist = new ArrayList<Student6308>();

        //创建Student对象
        Student6308 s1 = new Student6308("老陈", 21);
        Student6308 s2 = new Student6308("老郑", 20);
        Student6308 s3 = new Student6308("老余", 19);
        Student6308 s4 = new Student6308("老谢", 22);

        //往list集合内添加对象
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        //往collectionlist集合内添加对象
        collectionlist.add(s1);
        collectionlist.add(s2);
        collectionlist.add(s3);
        collectionlist.add(s4);

        //不同方法的遍历输入 list集合
        System.out.println("-----useIterator方法------");
        useIterator6308(collectionlist);
        System.out.println("--------------------");

        System.out.println("-----useForeach方法------");
        useForeach6308(collectionlist);
        System.out.println("--------------------");

        System.out.println("-----useList方法------");
        useList6308(list);
        System.out.println("--------------------");

        System.out.println("-----useArray方法------");
        useArray6308(collectionlist);

    }

    private static void useIterator6308(Collection<Student6308> collectionlist) {
        //（1）对于存储Student6308对象的泛型的集合Collection<E>
        //（2）用集合的迭代器遍历输出
        Iterator<Student6308> it = collectionlist.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    private static void useForeach6308(Collection<Student6308> collectionlist) {
        //（1）对于存储StudentXXXX对象的泛型的集合Collection<E>
        //（2）用增强for遍历输出
        for (Student6308 e : collectionlist) {
            System.out.println(e);
        }
    }

    private static void useList6308(List<Student6308> list) {
        //（1）对于存储StudentXXXX对象的泛型的集合List<E>
        //（2）按序号遍历输出
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void useArray6308(Collection<Student6308> collectionlist) {
        //（1）对于存储StudentXXXX对象的泛型集合Collection<E>
        //（2）调用Collection的<T> T[] toArray(T[] a)将集合转为数组
        //（3）通过数组遍历输出
        Student6308[] i = new Student6308[collectionlist.size()];
        collectionlist.toArray(i);
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j]);
        }
    }

    static class Student6308 {
        private String name;
        private int age;

        //有参构造
        public Student6308(String name, int age) {
            this.name = name;
            this.age = age;
        }

        //无参构造
        public Student6308() {
        }

        //获取姓名
        public String getName() {
            return name;
        }

        //设置姓名
        public void setName(String name) {
            this.name = name;
        }

        //获取年龄
        public int getAge() {
            return age;
        }

        //设置年龄
        public void setAge(int age) {
            this.age = age;
        }

        @Override
        //重写tostring方法
        public String toString() {
            return name + ":" + age;
        }
    }
}
