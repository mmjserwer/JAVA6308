package java6308.lesson03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Scanner;

public class EndDate6308 {
    public static void main(String[] args) {
        System.out.print("请按yyyy-mm-dd的格式输入开班日期：");
        Scanner sc = new Scanner(System.in);
        String kb = sc.nextLine();//输入开班日期
        System.out.println("培训15天,结业日期:" + calc6308(kb));
    }
    public static String calc6308(String kb) {
        //TemporalAccessor temp;
        String str = kb.replace(" ", "");//去除空格
        //判断传入的日期string是否符合iso标准即yyyy-mm-dd
        if (str.matches("(^\\d{4})-(0+[1-9]|1[012])-(0+[1-9]|[12][0-9]|3[01])")) {
            String a[] = str.split("-");//年月日分成三个部分
            int b[] = new int[3];
            for (int i = 0; i < 3; i++) {
                b[i] = Integer.parseInt(a[i]);//将string类型转换成int类型
            }
            //判断2月份是29还是28 超出返回null
            if (b[1] == 2) {
                if (b[0] % 400 == 0 || (b[0] % 4 == 0 && b[0] % 100 != 0)) {
                    if (b[2] > 29) {
                        return null;
                    }
                } else {
                    if (b[2] > 28) {
                        return null;
                    }
                }
            }
        } else {
            return null;
        }
        LocalDate date = LocalDate.parse(str);//解析传入的string类型
       /* String sdf = date.format(DateTimeFormatter.ISO_DATE);
        LocalDate date1 = LocalDate.parse(sdf);*/
        LocalDate date2 = date.plusDays(15);//计算日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 EEE", Locale.CHINESE);//格式化模板
        return date2.format(formatter);//返回格式化后计算的日期
    }
}

