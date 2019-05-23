package synchronizedLearn.sareLock;

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
