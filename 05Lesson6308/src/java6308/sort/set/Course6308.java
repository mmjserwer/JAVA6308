package java6308.sort.set;

import java.util.Comparator;
import java.util.Objects;

public class Course6308 implements Comparable<Course6308> {
    private String name;//课程名称
    private int credit;//学分
    private int score;//成绩
    private String term;//开课学期
    private String no;//课程编号

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Course6308() {
    }

    //课程名 开课学期 课程编号 学分 成绩
    public Course6308(String name, String term, String no, int credit, int score) {
        this.name = name;
        this.credit = credit;
        this.score = score;
        this.term = term;
        this.no = no;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course6308 that = (Course6308) o;
        return credit == that.credit && score == that.score && Objects.equals(name, that.name) && Objects.equals(term, that.term) && Objects.equals(no, that.no);
    }

    @Override
    public String toString() {
        return "成绩:" + score + "," + term + "," + credit + "学分【" + no + " " + name + "】";
    }

    @Override//成绩
    public int compareTo(Course6308 o) {
        int s1=o.score-getScore();
        int s2=s1==0?getName().compareTo(o.name):s1;
        int s3=s2==0?getCredit()-o.credit:s2;
        int s4=s3==0? getTerm().compareTo(o.term):s3;
        return s4;
    }

    public static int compareTwo(Course6308 o1, Course6308 o2) {

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
        int sort1 =  sum1 - sum2;
        //第二条件 学分
        int sort2 = sort1 == 0 ? o1.getCredit() - o2.getCredit() : sort1;
        int sort3=sort2==0? o1.getScore()-o2.getScore():sort2;
        int sort4=sort3==0? o1.getName().compareTo(o2.getName()):sort3;
        int sort5=sort4==0? o1.getNo().compareTo(o2.getNo()):sort4;
        return sort5;
    }


}
