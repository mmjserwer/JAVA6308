public class Score5305 {
    private String name;
    private int chinese;
    int math;
    private int english;

    public Score5305() {
    }

    public Score5305(String name, int chinese, int math, int english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
    }

    public Score5305(String str, int chinese, int math, int english, int sum) {

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
    public int getSun(){
        return getChinese()+getEnglish()+getMath();
    }
}
