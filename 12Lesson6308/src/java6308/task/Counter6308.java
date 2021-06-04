package java6308.task;

import java.util.*;
import java.util.stream.Collectors;

public class Counter6308 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("");
        Map<String, Long> collect = Arrays.asList(split).stream().collect(Collectors.groupingBy(String::new,Collectors.counting()));
        collect.keySet().stream().sorted(Comparator.comparing(s1->collect.get(s1)).reversed()).forEach(
                k->{
                    System.out.println(k+"="+collect.get(k));
                }
        );
    }
}
