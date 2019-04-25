package madokast;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimerCountListener implements ActionListener {
    private static TimerCountListener timerCountListener;
    public static TimerCountListener getInstance()
    {
        if(timerCountListener==null)
        {
            timerCountListener = new TimerCountListener();
        }

        return timerCountListener;
    }

    private TimerCountListener()
    {
        super();
    }

    private long startTime=0;
    private long nowTime=0;
    private int period=0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(startTime==0)
        {
            startTime=System.currentTimeMillis()/1000;
        }

        nowTime=System.currentTimeMillis()/1000;

        TimingCanvas.getInstance().paintString(period-(int)(nowTime-startTime));
        //System.out.println("period = " + period);

        if(TimingCanvas.getInstance().getSeconds()<=0)
        {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式


            InfoTextArea.getInstance().append("["+df.format(new Date())+"]Time over\n");
            TimerCount.getInstance().stop();
            TimeOverDialog.getInstance().setVisible(true);
            startTime=0;
            period=0;
        }

    }

    public void setPeriod(int period) {
        this.period = period;
    }
}