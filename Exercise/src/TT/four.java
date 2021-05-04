package TT;
import java.util.Scanner;
public class four {
    public static void main(String[] args) {
        int f;
        Scanner sc=new Scanner(System.in);
        f=sc.nextInt();
        int c=5*(f-32)/9;
        System.out.println("Celsius = "+c);
    }
}
