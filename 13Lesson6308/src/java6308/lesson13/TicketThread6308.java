package java6308.lesson13;

public class TicketThread6308 extends Thread {
    private int tickets;

    TicketThread6308(String name) {
        this.setName(name);
    }


    @Override
    public void run() {
        tickets=1;
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + "---第" + tickets);
            tickets++;
        }
    }
}
