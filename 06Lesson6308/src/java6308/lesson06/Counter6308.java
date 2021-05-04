package java6308.lesson06;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Counter6308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        count6308(str);
    }

    private static void count6308(String str) {
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();//定义TreeMap集合
        char[] array = str.toCharArray();//将字符串变成字符数组
        //遍历字符数组，得到每一个字符
        for (Character me : array) {
            Integer i = map.get(me);//拿到的字符作为键去集合看值是否为null
            //当值为null时则表示集合内没有字符，添加该字符，该字符作为键，1为值储存
            if (i == null) {
                map.put(me, 1);
            } else {
                //当值不为null时 值加1 重写该键和值
                i++;
                map.put(me, i);
            }
        }
        StringBuilder tt = new StringBuilder();//定义字符串缓冲区变量
        //遍历集合，得到键和值，按要求拼接
        Set<Character> set = map.keySet();
        for (Character key : set) {
            Integer value = map.get(key);
            if (key.equals(' ')) {
                tt.append("空格").append(":").append(value).append("个 ");
            } else {
                tt.append(key).append(":").append(value).append("个 ");
            }
        }
        String result = tt.toString();
        System.out.println(result);//输入结果
    }
}


