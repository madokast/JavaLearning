package tool.timer;

import javax.swing.*;

public class TimeCounterThread implements Runnable {
    int textFieldNumber;
    int seconds;
    JLabel[] timeJLabels;
    public TimeCounterThread(int textField, int second, JLabel[] timeJLabels) {
        this.textFieldNumber = textField;
        this.seconds = second;
        this.timeJLabels = timeJLabels;
    }

    @Override
    public void run() {
        final long start = System.currentTimeMillis()/1000;
        final long end = start+ seconds;
        try{
            while(true){
                long current = System.currentTimeMillis()/1000;
                long remain = end - current;
                timeJLabels[textFieldNumber].setText(""+(remain));
                Thread.currentThread().sleep(1000);
                if(remain<=0){
                    timeJLabels[textFieldNumber].setText("▇ ▇ ▇");
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
