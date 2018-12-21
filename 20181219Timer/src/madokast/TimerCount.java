package madokast;

import javax.swing.*;

public class TimerCount extends Timer {
    private static TimerCount timerCount;
    public static TimerCount getInstance()
    {
        if(timerCount==null)
        {
            timerCount=new TimerCount();
        }
        return timerCount;
    }

    private TimerCount()
    {
        super(100,TimerCountListener.getInstance());
    }

    public void start(int period) {
        TimerCountListener.getInstance().setPeriod(period);
        super.start();
    }
}
