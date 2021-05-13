package java6308.scores;

public class Score6308 implements Comparable <Score6308>{
    private String name;
    private int chinese;
    private int math;
    private int english;

    public Score6308() {
    }

    public Score6308(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }
    public int getSum(){
        return english+math+chinese;
    }
    @Override
    public int compareTo(Score6308 o) {
        int sort1=this.getSum()-o.getSum();
        int sort2=sort1==0? this.math-o.math:sort1;
        return sort2;
    }
}
