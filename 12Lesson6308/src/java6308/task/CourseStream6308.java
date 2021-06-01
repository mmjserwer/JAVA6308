package java6308.task;


import java.util.ArrayList;
import java.util.List;


public class CourseStream6308 {

  public static void main(String[] args) {


  }

  private static List<CourseXXXX> getCourses() {
    List<CourseXXXX> courses=new ArrayList<CourseXXXX>();
    courses.add(new CourseXXXX("A001", "C程序设计基础", "1上", 4, 80));
    courses.add(new CourseXXXX("A004", "离散数学", "1下", 3, 79));
    courses.add(new CourseXXXX("B002", "Pthon程序基础", "1下", 2, 85));
    courses.add(new CourseXXXX("A002", "面向对象程序设计", "2上", 3, 78));
    courses.add(new CourseXXXX("C012", "软件测试", "3下", 2, 72));
    courses.add(new CourseXXXX("C001", "Java程序高级开发", "3上", 2, 83));
    courses.add(new CourseXXXX("0003", "大学物理", "2上", 2, 77));
    courses.add(new CourseXXXX("C002", "软件工程", "3下", 3, 75));
    courses.add(new CourseXXXX("C011", "移动项目开发", "3下", 2, 87));
    courses.add(new CourseXXXX("B001", "操作系统", "2下", 3, 90));
    courses.add(new CourseXXXX("A005", "算法与数据结构", "2上", 3, 82));
    courses.add(new CourseXXXX("A003", "数据库原理", "2上", 3, 78));
    courses.add(new CourseXXXX("C003", "前端开发技术", "3上", 3, 69));
    courses.add(new CourseXXXX("B003", "网络基础", "2下", 3, 75));
    courses.add(new CourseXXXX("0001", "大学英语", "1上", 3, 80));
    courses.add(new CourseXXXX("0002", "高等数学", "1下", 2, 85));
    courses.add(new CourseXXXX("B004", "计算机网络", "1下", 4, 68));
    courses.add(new CourseXXXX("B005", "计算机数组原理", "2上", 4, 78));
    return courses;
  }
  private static class CourseXXXX {
    private String no;//课程编号
    private String name;//课程名称
    private String term;//开课学期
    private int credit;//学分
    private int score;//成绩
    
    public CourseXXXX() {
      super();
    }
    public CourseXXXX(String no,String name, String term, int credit, int score) {
      super();
      this.no=no;
      this.name = name;
      this.term = term;
      this.credit = credit;
      this.score = score;
    }
    public String getNo() {
      return no;
    }

    public void setNo(String no) {
      this.no = no;
    }
    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getTerm() {
      return term;
    }

    public void setTerm(String term) {
      this.term = term;
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

  }
    
}
