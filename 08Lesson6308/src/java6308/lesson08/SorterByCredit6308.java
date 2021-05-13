package java6308.lesson08;

import java.util.Comparator;

public class SorterByCredit6308 implements Comparator<Course6308> {

    @Override//按学分排序 比较器
    public int compare(Course6308 o1, Course6308 o2) {
        if (o1.getCredit() > o2.getCredit())
            return 1;
        if (o1.getCredit() < o2.getCredit())
            return -1;
        return 0;
    }
}
