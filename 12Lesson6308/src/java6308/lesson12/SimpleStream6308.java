package java6308.lesson12;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleStream6308 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            list.add(random.nextInt(60 - 40 + 1) + 40);
        }
        int sum = list.stream().filter(SimpleStream6308::isPrime).mapToInt(n -> {
            System.out.print(n + " ");
            return n;
        }).sum();
        System.out.println("=" + sum);
    }

    private static boolean isPrime(Integer integer) {
        if (integer == 1) {
            return true;
        } else if (integer % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i * i <= integer; i += 2) {
                if (integer % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
