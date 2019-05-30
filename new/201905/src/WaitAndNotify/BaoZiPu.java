package WaitAndNotify;

import java.security.spec.ECField;
import java.util.concurrent.ThreadLocalRandom;

public class BaoZiPu extends Thread{
    private BaoZi bz;

    public BaoZiPu(BaoZi bz){
        this.bz = bz;
    }

    @Override
    public void run(){
        int num = 0;


        while(true){
            synchronized (bz){
                if(bz.flag==true){
                    try{
                        bz.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if(num%2==0){
                    bz.pi="123";
                    bz.xian="321";
                }else{
                    bz.pi="abc";
                    bz.xian="cda";
                }

                num++;
                System.out.println("正在生产"+bz.pi+bz.xian);


                try {
                    Thread.sleep(1000);
                }catch (Exception e){e.printStackTrace();}


                bz.flag=true;
                System.out.println("包子已经生产好了"+bz.pi+bz.xian);
                bz.notify();
            }
        }


    }
}
