package java6308.bank;

public class DrinkWater6308 {
    private static Object obj = new Object();
    private static int waters = 20;

    public static void main(String[] args) {
        Thread t1 = new Thread(DrinkWater6308::drinking6308, "狗");
        Thread t2 = new Thread(DrinkWater6308::drinking6308, "猫");
        t1.start();
        t2.start();
    }

    private static void drinking6308() {
        synchronized (obj) {
            String name = Thread.currentThread().getName();
            while (waters > 0) {
                if (name.equals("狗")) {
                    waters = waters - 5;
                } else if (name.equals("猫")) {
                    waters = waters - 2;
                }
                System.out.println(name + "已喝水，剩" + waters);
            }
            System.out.println(name + ",请加水！");
        }

    }
}