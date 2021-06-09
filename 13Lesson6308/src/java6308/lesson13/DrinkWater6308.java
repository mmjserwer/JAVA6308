package java6308.lesson13;

public class DrinkWater6308 {
    private static int waters=20;

    public static void main(String[] args) {
        Thread t1 = new Thread(DrinkWater6308::drinking6308, "狗");
        Thread t2 = new Thread(DrinkWater6308::drinking6308, "猫");
        t1.start();
        t2.start();
    }

    private static void drinking6308() {
        String name=Thread.currentThread().getName();
        while(waters>0){
            if(name.equals("狗")){
                waters=waters-5;
                if(waters>0){
                    System.out.println(name+"已喝水，剩"+waters);
                }
                else {
                    break;
                }
            }else if(name.equals("猫")){
                waters=waters-2;
                if(waters>0){
                    System.out.println(name+"已喝水，剩"+waters);
                }
                else {
                    break;
                }
            }
        }
        System.out.println(name+",请加水！");
    }
}
