package tool.timer;

import javax.swing.*;

public class TimeCounterThread implements Runnable {
    int textFieldNumber;
    int seconds;
    JTextField[] jTextFields;
    public TimeCounterThread(int textField, int second, JTextField[] jTextFields) {
        this.textFieldNumber = textField;
        this.seconds = second;
        this.jTextFields = jTextFields;
    }

    @Override
    public void run() {
        final long start = System.currentTimeMillis()/1000;
        final long end = start+ seconds;
        try{
            while(true){
                long current = System.currentTimeMillis()/1000;
                long remain = end - current;
                jTextFields[textFieldNumber].setText(""+(remain));
                Thread.currentThread().sleep(1000);
                if(remain<=0){
                    jTextFields[textFieldNumber].setText("Time out");
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
