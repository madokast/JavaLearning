package madokast;

import javax.swing.*;
import java.awt.*;

public class ATW3 {
    public static void commonComponebt(){
        Frame f =new Frame("commonComponebt");
        Button bt = new Button("OK");
        CheckboxGroup cbg = new CheckboxGroup();
        Checkbox male = new Checkbox("male",cbg,true);
        Checkbox female = new Checkbox("female",cbg,false);
        Checkbox married = new Checkbox("married",false);
        Choice colorChoice = new Choice();
        List colorList = new List(6,true);
        TextArea ta =new TextArea(5,20);
        TextField tf = new TextField(50);

        colorChoice.add("cc1");
        colorChoice.add("cc2");
        colorChoice.add("cc3");

        colorList.add("cl1");
        colorList.add("cl2");
        colorList.add("cl3");

        Panel cheackPanle = new Panel();
        cheackPanle.add(colorChoice);
        cheackPanle.add(male);
        cheackPanle.add(female);
        cheackPanle.add(married);

        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(cheackPanle);

        Box top =Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        Box down = Box.createHorizontalBox();
        down.add(tf);
        down.add(bt);

        Box all = Box.createVerticalBox();
        all.add(top);
        all.add(down);

        f.add(all);
        f.pack();
        f.setVisible(true);


    }

    public static void dialog(){
        Frame f = new Frame("dialog");
        Dialog d1 = new Dialog(f,"modal",true);
        Dialog d2 = new Dialog(f,"non-modal",false);

        Button b1 = new Button("open modal dialog");
        Button b2 = new Button("open non-modal dialog");

        d1.setBounds(20,30,300,400);
        d2.setBounds(20,30,300,400);

        b1.addActionListener(e->d1.setVisible(true));
        b2.addActionListener(e->d2.setVisible(true));

        f.add(b1);
        f.add(b2,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);

    }

    public static void main(String[] args) {
        //commonComponebt();
        dialog();
    }
}
