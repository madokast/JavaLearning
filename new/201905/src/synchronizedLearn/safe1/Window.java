package synchronizedLearn.safe1;

/**
 * 利用同步代码块解决线程安全
 * synchronized{锁对象}(临界代码)
 */

public class Window implements Runnable {
    private int ticket = 100;


    @Override
    public void run(){
        while (true){
            if(ticket>0){
                try {
                    Thread.currentThread().sleep(10);
                }catch (Exception e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"卖出"+ticket);
                ticket--;
            }
            else {
                break;
            }
        }
    }
}
