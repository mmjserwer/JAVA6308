package java6308.generic;

public class MyMath6308<T extends Comparable<T>> {
    private T date;

    public MyMath6308() {
    }

    public MyMath6308(T date) {
        this.date = date;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public  MyMath6308<T> min6308(MyMath6308<T> a) {
        if (date.compareTo(a.date) > 0) {
            return a;
        } else {
            return this;
        }
    }

    public  MyMath6308<T> max6308(MyMath6308<T> a) {
        if (date.compareTo(a.date) < 0) {
            return a;
        } else {
            return this;
        }
    }

    //需要重写tostring 不然返回其地址
    @Override
    public String toString() {
        return ""+date;
    }
}
