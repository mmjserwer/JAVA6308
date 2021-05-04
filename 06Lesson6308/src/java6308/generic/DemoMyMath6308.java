package java6308.generic;

import java.time.LocalDate;

public class DemoMyMath6308{
    public static void main(String[] args) {
        MyMath6308<String> a1=new MyMath6308<String>("aa");
        MyMath6308<String> a2=new MyMath6308<String>("bb");
        System.out.println("两个字符串的大:"+a2.max6308(a1)+" 两个字符串的小："+a2.min6308(a1));
        MyMath6308<Integer> b1=new MyMath6308<Integer>(1);
        MyMath6308<Integer> b2=new MyMath6308<Integer>(2);
        System.out.println("两个Integer的大"+b1.max6308(b2)+" 两个Integer的小："+b1.min6308(b2));
        MyMath6308<Character> c1=new MyMath6308<Character>('a');
        MyMath6308<Character> c2=new MyMath6308<Character>('b');
        System.out.println("两个Character的大"+c1.max6308(c2)+" 两个Character的小："+c1.min6308(c2));
        //MyMath6308<LocalDate> d1=new MyMath6308<LocalDate>();
        //LocalDate 不在界限内 需要实现 Comparable<LocalDate>接口

    }
}
