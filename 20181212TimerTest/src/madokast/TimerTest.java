package madokast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class TimerTest {
    public static void main(String[] args) {
        Frame f =new Frame();
        Button b=new Button();

        ActionListener al = e->{
            System.out.println(LocalTime.now());
        };

        Timer timer = new Timer(100,al);

        b.addActionListener(al);
        timer.start();

        f.add(b);
    }
}
