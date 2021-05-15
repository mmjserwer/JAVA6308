package java6308.scores;

public class Score6308 implements Comparable <Score6308>{
    private String name;
    private int chinese;
    private int math;
    private int english;
    private int sum;


    public Score6308(String name, int chinese, int math, int english, int sum) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.sum = sum;
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

    public Score6308() {
    }


    public int getSum(){
        return english+math+chinese;
    }
    @Override
    public int compareTo(Score6308 o) {
        return 0;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
