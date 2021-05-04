package TT;
import java.util.*;
public class two {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String str=sc.nextLine().replace(" ","");
        int n=(int)Math.sqrt((N+1)/2);
        for(int i=n;i>1;i--){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<2*i-1;k++){
                System.out.print(str);
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<2*i-1;k++){
                System.out.print(str);
            }
            System.out.println();
        }
        int yushu=N-(2*n*n-1);
        System.out.println(yushu);
    }
}
