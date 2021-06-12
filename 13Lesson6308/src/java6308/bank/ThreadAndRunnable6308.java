package java6308.bank;


public class ThreadAndRunnable6308 {
    public static void main(String[] args) {

        saleByRunnable6308();
    }
    private static void saleByRunnable6308() {
        TicketRunnable6308 tr = new TicketRunnable6308();
        Thread t1 = new Thread(tr, "陈思杰1");
        Thread t2 = new Thread(tr, "陈思杰2");
        Thread t3 = new Thread(tr, "陈思杰3");
        t1.start();
        t2.start();
        t3.start();

    }

}
