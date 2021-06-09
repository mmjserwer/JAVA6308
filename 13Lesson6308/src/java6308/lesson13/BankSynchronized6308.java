package java6308.lesson13;

public class BankSynchronized6308 {
    static Object obj = new Object();
    private static BankAccount6308 account;

    public BankSynchronized6308(BankAccount6308 account) {
        this.account = account;
    }

    public static void main(String[] args) throws InterruptedException {

        account = new BankAccount6308("211906308", 1000.0);
        Thread t1 = new Thread(BankSynchronized6308::bank6308, "会计");
        Thread t2 = new Thread(BankSynchronized6308::bank6308, "出纳");
        /* synchronized (account){}*/
        /* synchronized (t1.getName()){}*/
        System.out.println(account.getBankID() + "账上开始余额：" + account.getBalance() + "元");
        long begin = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long over = System.currentTimeMillis();
        System.out.println(account.getBankID() + "账上最终余额：" + account.getBalance() + "元");
        System.out.println("所花时间:" + (over - begin));
    }

    private static void bank6308() {
        String name = Thread.currentThread().getName();
        String action = "";
        double money = 0, b = 0;
        if (name.equals("会计")) {
            money = 300;
            action = "存入";
        } else if (name.equals("出纳")) {
            money = -100;
            action = "取出";
        }
/*
        for(int i=1;i<4;i++){
                b=account.getBalance()+money;
                System.out.println(name+action+Math.abs(money));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        account.setBalance(b);*/

        for (int i = 1; i < 4; i++) {
            synchronized (obj) {
                b = account.getBalance() + money;
                System.out.println(name + action + Math.abs(money));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(b);
            }

        }
    }
}
