package java6308.lesson13;

public class TicketRunnable6308 implements Runnable {
    private int tickets=1;

    @Override
    public void run() {
        while (tickets < 11) {
            System.out.println(Thread.currentThread().getName() + "---" + tickets++);
        }
    }
}
