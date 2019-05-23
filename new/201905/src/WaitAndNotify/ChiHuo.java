package WaitAndNotify;

public class ChiHuo extends Thread{
    private BaoZi bz;
    public ChiHuo(BaoZi bz){
        this.bz = bz;
    }

    @Override
    public void run(){
        while (true){
            synchronized (bz){
                if(bz.flag) {
                    System.out.println("吃包子" + bz.pi + bz.xian);
                    bz.flag = false;
                    System.out.println("包子吃完了，请开始生产");
                    bz.notify();
                }

            }


        }

    }
}
