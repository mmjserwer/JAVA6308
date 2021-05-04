package java6308.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapForeach6308 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("aa", "1");
        map.put("bb", "3");
        map.put("aa", "9");
        map.put("cc", "8");
        map.put("dd", "5");
        System.out.println(map);
        System.out.println(map.get("bb"));
        System.out.println(map.containsKey("cc"));
        System.out.println(map.remove("dd"));
        System.out.println(map.remove("dd"));
        System.out.println(map);
        System.out.println();
        System.out.println("利用Key的Set集合遍历Map集合的方法");
        print6308(map);
        System.out.println();
        System.out.println("利用Set<Map.Entry<K,V>>的集合遍历Map集合");
        print6308(map.entrySet());

    }
    //利用Key的Set集合遍历Map集合的方法
    private static void print6308(Map<String,String> map1) {
        Set<String> set = map1.keySet();
        for(String str:set){
            System.out.print(str+"--"+map1.get(str));
        }
    }
    //利用Set<Map.Entry<K,V>>的集合遍历Map集合
    private static void print6308(Set<Map.Entry<String,String>> set1) {
        Iterator<Map.Entry<String, String>> iterator = set1.iterator();
        for(Map.Entry<String,String> me:set1){
            while(iterator.hasNext()){
                System.out.print(iterator.next()+" ");
            }
        }
    }

}
