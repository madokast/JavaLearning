package thread;

public class MyThread extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(this.getName()+"  "+i);
            try{
                Thread.currentThread().sleep(1);
            }catch (Exception e){}
        }
    }
}
