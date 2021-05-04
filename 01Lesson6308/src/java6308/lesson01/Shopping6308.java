package java6308.lesson01;


import java.util.*;

public class Shopping6308 {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Market6308 a[] = new Market6308[3];
        System.out.println("输入3家超市名字");
        for (int i = 0; i < a.length; i++) {
            a[i] = new Market6308();
            a[i].setMarketname(sc.nextLine());
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].getMarketname() + "的仓库商品");
            if (i == 0) {
                System.out.println("1个商品");
                Product6308 c = new Product6308();
                c.setProductname(sc.nextLine());
                a[i].setProductlist(new Product6308[]{c});
                Product6308 s2[] = {c};
            } else if (i == 1) {
                System.out.println("2个商品");
                Product6308 c = new Product6308();
                Product6308 d = new Product6308();
                c.setProductname(sc.nextLine());
                d.setProductname(sc.nextLine());
                a[i].setProductlist(new Product6308[]{c, d});
                Product6308 s2[] = {c, d};

            } else {
                System.out.println("3个商品");
                Product6308 c = new Product6308();
                Product6308 d = new Product6308();
                Product6308 e = new Product6308();
                c.setProductname(sc.nextLine());
                d.setProductname(sc.nextLine());
                e.setProductname(sc.nextLine());
                a[i].setProductlist(new Product6308[]{c, d, e});
                Product6308 s[] = {c, d, e};

            }
        }


        Person6308 k = new Person6308();
        System.out.println("输入购买者名字：");
        k.setPersonname(sc.nextLine());
        System.out.println("输入去的超市");
        String ac = sc.nextLine();
       /* System.out.println("输入购买商品种类(1种)");
        int zl = sc.nextInt();*/
//     if (zl == 1) {
        System.out.println("输入购买商品");
        String tt = sc.nextLine();
        for (int i = 0; i < a.length; i++) {
            if (a[i].getMarketname().equals(ac)) {
                Product6308 shoplist = k.shopping(a[i], tt);
                if (shoplist != null) {
                    System.out.println(k.getPersonname() + "的购物清单：" + "[" + tt + "]");
                    System.out.println(k.getPersonname() + "在" + a[i].getMarketname() + "买到了：" + shoplist.getProductname());
                } else {
                    System.out.println("没买到");
                }
            }
//            }
        }
        System.out.println("设置购买超市商品");
        System.out.println("输入三个超市商品");
        Product6308 surperlist[]={new Product6308(sc.nextLine()),new Product6308(sc.nextLine()),new Product6308(sc.nextLine())};
        System.out.println("输入购买商品种类(2种)");
        String t = sc.nextLine();
        String r = sc.nextLine();
        int j=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].getMarketname().equals(ac)) {
                j=i;
            }
        }

        Market6308 s = new Market6308(ac,surperlist);

        Product6308 shoplist[] = {new Product6308(t), new Product6308(r)};
        System.out.println(k.getPersonname() + "的购物清单：" + "[" + Arrays.toString(shoplist) + "]");
        System.out.println(k.getPersonname() + "在" + a[j].getMarketname() + "买到了：" + Arrays.toString(shoplist));

    }

}




