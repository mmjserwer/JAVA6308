package java6308.lesson05;

import java.util.HashSet;
import java.util.Random;

public class HashSetRandom6308 {
    public static void main(String[] args) {
        Random a = new Random();
        HashSet<Integer> list = new HashSet<Integer>();//实例化Hashset集合
        while (list.size() < 10) {
            int b = a.nextInt(80 - 50 + 1) + 50;//生成随机数50-80
            list.add(b);//将符合的随机数放入集合内
        }
        System.out.print("10个50-80内的随机数：");
        for (Integer s : list)//for增强
            System.out.print(s+" ");//输出集合
    }
}

