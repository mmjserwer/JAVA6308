package java6308.bank;

public class TicketRunnable6308 implements Runnable {
    private int tickets = 1;

    @Override
    public void run() {
        while (tickets < 11) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + "---" + tickets++);
            }
        }
    }
}
