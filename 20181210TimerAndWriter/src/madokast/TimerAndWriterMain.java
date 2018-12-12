package madokast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TimerAndWriterMain {
    private Frame f = new Frame("time and writer");
    private TextArea ta = new TextArea(6,40);
    //private TextField tf = new TextField(20);
    private Button start = new Button("start");
    private Button stop = new Button("stop");
    private double seconds = 0;
    private PrintSeconds printSeconds = new PrintSeconds();

    private void init(){
        Panel top = new Panel();
        top.add(ta);



        Panel button = new Panel();
        button.setMaximumSize(new Dimension(100,20));
        CardLayout cardStopAndStart  = new CardLayout();
        button.setLayout(cardStopAndStart);
        button.add("stop",stop);
        button.add("start",start);
        cardStopAndStart.show(button,"start");

        Panel down = new Panel();
        down.setLayout(new BoxLayout(down,BoxLayout.X_AXIS));
        //down.add(Box.createHorizontalGlue());
        down.add(button);
        //down.add(Box.createHorizontalGlue());
        //down.add(tf);
        printSeconds.setMaximumSize(new Dimension(100,20));
        down.add(printSeconds);
        down.add(Box.createHorizontalStrut(10));

        ActionListener timeCountListener = e->
        {
            seconds+=0.1;
        };

        ActionListener timeWriteListener = e->
        {
            //tf.setText(((int)seconds)+" s");
            printSeconds.repaint();

        };





        Timer timerCount = new Timer(100,timeCountListener);
        Timer timerWrite = new Timer(1000,timeWriteListener);

        ActionListener buttonSwitchListener = e->
        {
            switch (e.getActionCommand())
            {
                case "stop":
                    timerCount.stop();
                    cardStopAndStart.show(button,"start");
                    break;
                case "start":
                    timerCount.start();
                    cardStopAndStart.show(button,"stop");
                    break;
            }
        };
        stop.addActionListener(buttonSwitchListener);
        start.addActionListener(buttonSwitchListener);







        f.add(top);
        f.add(down,BorderLayout.SOUTH);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.pack();
        f.setVisible(true);

        timerWrite.start();
    }

    public static void main(String[] args) {
        new TimerAndWriterMain().init();
    }

    class PrintSeconds extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.setColor(new Color(0x0109DC));
            g.setFont(new Font("Times",Font.BOLD,10));
            g.drawString((int)seconds+"s",80,14);
        }
    }

}
