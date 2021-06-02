package java6308.lesson12;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CourseStream6308 {

  public static void main(String[] args) {
    long count=0;
    count=getCourses().stream().filter(s -> s.getScore() >= 85).count();
    System.out.println("======85分以上的课程名单======\n"+"共"+count+"门");
    getCourses().stream().filter(s -> s.getScore() >= 85).forEach(s->{
      System.out.println(s.getNo()+" "+String.format("%-12s",s.getName())+s.getTerm()+","+s.getCredit()+","+s.getScore());
    });
    OptionalDouble average = getCourses().stream().mapToInt(Course6308::getScore).average();
    System.out.println("【1】所有课程的平均值："+String.format("%.2f",average.getAsDouble()));
    System.out.println("【2】最高分的课程:");
    Optional<Course6308> collect = getCourses().stream().collect(Collectors.maxBy(Comparator.comparing(Course6308::getScore)));
    System.out.println(collect.get().getNo()+" "+String.format("%-12s",collect.get().getName())+collect.get().getTerm()+","+collect.get().getCredit()+","+collect.get().getScore());
    System.out.println("【3】最低分的课程:");
    Optional<Course6308> collect1 = getCourses().stream().collect(Collectors.minBy(Comparator.comparing(Course6308::getScore)));
    System.out.println(collect1.get().getNo()+" "+String.format("%-12s",collect1.get().getName())+collect1.get().getTerm()+","+collect1.get().getCredit()+","+collect1.get().getScore());
  }

  private static List<Course6308> getCourses() {
    List<Course6308> courses=new ArrayList<Course6308>();
    courses.add(new Course6308("A001", "C程序设计基础", "1上", 4, 80));
    courses.add(new Course6308("A004", "离散数学", "1下", 3, 79));
    courses.add(new Course6308("B002", "Pthon程序基础", "1下", 2, 85));
    courses.add(new Course6308("A002", "面向对象程序设计", "2上", 3, 78));
    courses.add(new Course6308("C012", "软件测试", "3下", 2, 72));
    courses.add(new Course6308("C001", "Java程序高级开发", "3上", 2, 83));
    courses.add(new Course6308("0003", "大学物理", "2上", 2, 77));
    courses.add(new Course6308("C002", "软件工程", "3下", 3, 75));
    courses.add(new Course6308("C011", "移动项目开发", "3下", 2, 87));
    courses.add(new Course6308("B001", "操作系统", "2下", 3, 90));
    courses.add(new Course6308("A005", "算法与数据结构", "2上", 3, 82));
    courses.add(new Course6308("A003", "数据库原理", "2上", 3, 78));
    courses.add(new Course6308("C003", "前端开发技术", "3上", 3, 69));
    courses.add(new Course6308("B003", "网络基础", "2下", 3, 75));
    courses.add(new Course6308("0001", "大学英语", "1上", 3, 80));
    courses.add(new Course6308("0002", "高等数学", "1下", 2, 85));
    courses.add(new Course6308("B004", "计算机网络", "1下", 4, 68));
    courses.add(new Course6308("B005", "计算机数组原理", "2上", 4, 78));
    return courses;
  }
  private static class Course6308 {
    private String no;//课程编号
    private String name;//课程名称
    private String term;//开课学期
    private int credit;//学分
    private int score;//成绩
    
    public Course6308() {
      super();
    }
    public Course6308(String no,String name, String term, int credit, int score) {
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
