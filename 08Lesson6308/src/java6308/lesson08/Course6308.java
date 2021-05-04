package java6308.lesson08;

import java.util.Objects;

public class Course6308  {
    public int credit;//学分
    private String name;//课程名称
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
    public int hashCode() {
        return Objects.hash(name, credit, score, term, no);
    }

    @Override
    public String toString() {
        return "成绩:" + score + "," + term + "," + credit + "学分【" + no + " " + name + "】";
    }



}
