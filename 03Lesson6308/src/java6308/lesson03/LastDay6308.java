package java6308.lesson03;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class LastDay6308 {
    public static void main(String[] args) {
        System.out.println("计算某月的最后一天");
        System.out.print("请按yyyy-mm的格式输入:");
        Scanner sc=new Scanner(System.in);
        String rq=sc.nextLine();
        System.out.println("本月最后一天是"+getLastDay(rq)+"日");

    }
    public static String getLastDay(String rq){
        //TemporalAccessor temp;
        String str = rq.replace(" ", "");//去除空格
        int b[] = new int[2];
        //判断传进来的string类型的日期是否符合iso标准即yyyy-mm或者yyyy-m
        if (str.matches("(^\\d{4})-(0?[1-9]|1[012])") ){
            String a[] = str.split("-");//将年和月分开
            for (int i = 0; i < 2; i++) {
                b[i] = Integer.parseInt(a[i]);//将string类型的年和月转换成int类型
            }
        }
        else{
            return null;//不符合符合null
        }
        LocalDate date=LocalDate.of(b[0],b[1],1);//创建一个localdate对象 date 为date进行初始化 日定为1号 年和月为传进来的参数
        TemporalAdjuster adjuster = TemporalAdjusters.lastDayOfMonth();//计算规则为该月的最后一天
        LocalDate date1 = date.with(adjuster);//修改日期通过创建新的localdate对象 date1
        String result=date1.getDayOfMonth()+"";//通过getdayofmoth方法得到该日期的日 返回类型的string类型
        return result;
    }
}
