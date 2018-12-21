package madokast;

import java.awt.*;

public class TimingCanvas extends Canvas {
    private static TimingCanvas timingCanvas;
    private static final int CANVAS_WIDTH = 100;
    private static final int CANVAS_HEIGHT = 30;

    public static TimingCanvas getInstance()
    {
        if(timingCanvas==null)
        {
            timingCanvas=new TimingCanvas();
            timingCanvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        }

        return timingCanvas;
    }

    private String time;
    private int seconds;

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(0x000000));
        g.setFont(new Font("宋体",Font.BOLD,20));
        g.drawString(time,0,20);

    }

    public TimingCanvas(){
        time="00:00";
    }

    public void paintString(String str){
        time=str;
        repaint();
    }

    public void paintString(int seconds){
        this.seconds=seconds;

        int second = seconds%60;
        int minute = seconds/60;

        time=minute+":";
        if(second<10)
        {
            time=time+"0";
        }
        time=time+second;

        repaint();
    }

    public int getSeconds() {
        return seconds;
    }
}
