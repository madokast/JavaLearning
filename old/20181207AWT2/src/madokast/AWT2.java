package madokast;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.plaf.basic.BasicListUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.concurrent.BrokenBarrierException;

import static java.awt.BorderLayout.*;

public class AWT2 {
    private Frame f =new Frame("test");
    private Box h = Box.createHorizontalBox();
    private Box v = Box.createVerticalBox();


    public void windowInitialize(){
        f.setLayout(new BoxLayout(f,BoxLayout.Y_AXIS));

        h.add(new Button("1"));
        h.add(Box.createHorizontalGlue());
        h.add(new Button("2"));
        v.add(new Button("1"));
        v.add(Box.createVerticalStrut(10));
        v.add(new Button("2"));

        f.add(h, SOUTH);
        f.add(v);

        f.pack();
        f.setVisible(true);
    }



    public static void main(String[] args) {
        new AWT2().windowInitialize();
    }
}
