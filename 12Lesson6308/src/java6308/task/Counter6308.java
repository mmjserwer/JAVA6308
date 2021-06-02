package java6308.task;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Counter6308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("");
        /*Arrays.asList(split).stream().collect(Collectors.groupingBy(String::new, TreeMap::new, Collectors.counting())).forEach(
                (k, v) -> System.out.println(k + "==" + v)
        );*/
        Map<String, List<String>> collect = Arrays.asList(split).stream().collect(Collectors.groupingBy(String::new));
        Set<Map.Entry<String, List<String>>> entries = collect.entrySet();

    }
}
