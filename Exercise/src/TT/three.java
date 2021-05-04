package TT;
import java.util.*;
public class three {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str;
        str=sc.nextLine();
        int a[]=new int[10];
        for(int i=0;i<str.length();i++){
            int t=Integer.parseInt(str.charAt(i) + "");
            a[t]++;
        }
        for(int i=0;i<10;i++)
        {
            if(a[i]!=0){
                System.out.println(i+":"+a[i]);
            }
        }
    }
}
