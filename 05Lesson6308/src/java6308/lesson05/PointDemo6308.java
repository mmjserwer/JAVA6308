package java6308.lesson05;

import java.util.*;


public class PointDemo6308 {
    public static void main(String[] args) {
        demo1();//第一题方法

        demo2();//第二题方法

        demo3();//第三题方法
    }
    public static class Point6308 implements Comparable<Point6308> {
        private int x;
        private int y;
        public Point6308() {

        }
        public Point6308(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override//重写hashcode方法
        public int hashCode() {
            return Objects.hash(x,y);
        }

        @Override//重写tostring方法
        public String toString() {
            return "("+x+","+y+")";
        }

        @Override//重写equals方法
        public boolean equals(Object obj) {
            if(this==obj) return true;
            if(obj==null) return false;
            if(obj instanceof Point6308){
                Point6308 s=(Point6308)obj;//下转型
                return s.x==this.x&&s.y==this.y;
            }else{
                return  false;
            }
        }
        @Override//compareto方法实现
        public int compareTo(Point6308 o) {
            return x-o.x==0?y-o.y:x-o.x;
        }
    }

    public static void demo1() {
        //List集合的查找与对象相等
        System.out.println("------第一题-------");
        Collection<Point6308> list=new ArrayList<Point6308>();
        create(list);
        System.out.println(list.contains(new Point6308(11,15)));
    }

    public static void demo2() {
        //Set集合排除相同对象的方法
        System.out.println("--------第二题---------");
        Collection<Point6308> list=new HashSet<Point6308>();
        create(list);
        System.out.println(list);

    }
    public static void demo3() {
        //TreeSet集合排重、排序的方法
        System.out.println("--------第三题------");
        Collection<Point6308> list=new TreeSet<Point6308>();
        create((Collection<Point6308>) list);
        System.out.println(list);
    }

    private static void create(Collection<Point6308> list) {
        //添加元素
        list.add(new Point6308(1, 2));
        list.add(new Point6308(21, 31));
        list.add(new Point6308(11, 15));
        list.add(new Point6308(1, 2));
        list.add(new Point6308(21, 17));
        list.add(new Point6308(13, 15));
    }

}
