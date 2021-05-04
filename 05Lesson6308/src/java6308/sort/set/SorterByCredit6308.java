package java6308.sort.set;

import java.util.Comparator;

public class SorterByCredit6308 implements Comparator<Course6308> {
    @Override//按学分排序 比较器
    public int compare(Course6308 o1, Course6308 o2) {
        int s=o1.getCredit()-o2.getCredit();
        int s1=s==0?o1.getTerm().compareTo(o2.getTerm()):s;
        int s2=s1==0? o1.getScore()-o2.getScore():s1;
        int s3=s2==0? o1.getName().compareTo(o2.getName()):s2;
        int s4=s3==0? o1.getNo().compareTo(o2.getNo()):s3;
        return s4;
    }

}
