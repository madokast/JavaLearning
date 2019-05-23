package thread;

import javax.sound.midi.Soundbank;

/**
 * かいさつ
 */
public class KaiSatu implements Runnable {

    @Override
    public void run() {

        int all = 0;

        while (true) {
            synchronized (Ticket.signal) {
                if (Ticket.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + "售完");
                    Ticket.report(Thread.currentThread().getName(), all);
                    break;
                }
                try {
                    Thread.currentThread().sleep(Randoms.nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Ticket.sell();
                all++;
                System.out.println(Thread.currentThread().getName() + "卖出1张票，还剩" + Ticket.getNum());
            }
        }
    }
}
