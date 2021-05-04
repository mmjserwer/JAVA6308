package TT;


import java.io.BufferedReader;
import java.io.InputStreamReader;

 public class five {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] num=new String[n];
        String[] a=new String[n];
        String[] b=new String[n];
        String[] f=new String[n];
        for(int i=0;i<n;i++) {
            String[] s = bf.readLine().split(" ");
            num[i]=s[0];
            a[i]=s[1];
            b[i]=s[2];
        }
        int m = Integer.parseInt(bf.readLine());
        String[] ss = bf.readLine().split(" ");
        for(int i=0;i<m;i++) {
            f[i]=ss[i];
        }
        bf.close();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(f[i].equals(a[j])) {
                    System.out.println(num[j]+" "+b[j]);
                    break;
                }
            }
        }
    }
}
