package java6308.bank;

import java6308.lesson13.TicketRunnable6308;
import java6308.lesson13.TicketThread6308;

public class ThreadAndRunnable6308 {
    public static void main(String[] args) {

        saleByRunnable6308();
    }
    private static void saleByRunnable6308() {
        java6308.lesson13.TicketRunnable6308 tr = new TicketRunnable6308();
        Thread t1 = new Thread(tr, "陈思杰1");
        Thread t2 = new Thread(tr, "陈思杰2");
        Thread t3 = new Thread(tr, "陈思杰3");
        t1.start();
        t2.start();
        t3.start();

    }

}
