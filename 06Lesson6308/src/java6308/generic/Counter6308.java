package java6308.generic;

import java.util.*;
import java.util.function.BiFunction;

public class Counter6308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        count6308(str);

    }
    private static void count6308(String str){


        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();//定义TreeMap集合
        char[] array = str.toCharArray();//将字符串变成字符数组
        for(Character ch:array){
            Integer value=map.get(ch);
            if(value==null){
                value=1;
                map.put(ch, value);
            }else{
                // map.merge(ch, value, Integer::sum);
                map.merge(ch, value, new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        integer2=1;
                        return integer+integer2;
                    }
                });
            }
        }
        /*StringBuilder tt = new StringBuilder();//定义字符串缓冲区变量
        Set<Character> set = map.keySet();
        for (Character key : set)
            Integer value = map.get(key);
            if (key.equals(' ')) {
                tt.append("空格").append(":").append(value).append("个 ");
            } else {
                tt.append(key).append(":").append(value).append("个 ");
            }
        }
        String result = tt.toString();
        System.out.println(result);//输入结果*/

        List<Map.Entry<Character, Integer>> entries = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        entries.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                int sort1 = o1.getValue() - o2.getValue();
                int sort2=sort1==0?o1.getKey().compareTo(o2.getKey()):sort1;
                return sort2;
            }
        });

        for(Map.Entry<Character, Integer> me:entries){
            if(me.getKey().equals(' ')){
                System.out.print("空格："+me.getValue()+"个 ");
            }else{
                System.out.print(me.getKey()+":"+me.getValue()+"个 ");
            }
        }

    }

}
