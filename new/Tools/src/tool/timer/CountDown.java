package tool.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.FeatureDescriptor;

/**
 * 倒计时软件
 */

public class CountDown {
    private final static int NUM = 5;
    private static JPanel panelShow = new JPanel();
    private static JTextField[] textFields = new JTextField[NUM];//文本
    static {
        GridLayout gridLayout = new GridLayout(NUM,1);
        panelShow.setLayout(gridLayout);
        for (int i = 0; i < NUM; i++) {
            textFields[i] = new JTextField(10);
            textFields[i].setEnabled(false);
            textFields[i].setDisabledTextColor(Color.red);
            panelShow.add(textFields[i]);
        }
    }


    private static JPanel panelInput = new JPanel();
    private static JTextField textFieldInput = new JTextField(10);
    static {
        textFieldInput.setEnabled(true);
        textFieldInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    String input = textFieldInput.getText();
                    textFieldInput.setText("");
                    try{
                        final String[] s = input.split(" ");
                        int num = Integer.valueOf(s[0]);
                        int second = Integer.valueOf(s[1])*60;
                        new Thread(new TimeCounterThread(num,second,textFields)).start();
                    }catch (Exception ee){
                        ee.printStackTrace();
                        textFields[NUM-1].setText(input+"输入有误! 'No S'");
                    }

                }
            }
        });

        panelInput.add(textFieldInput);
    }

    //window
    private static JFrame frame;
    static {
        frame =  new JFrame();
        frame.add(panelShow);
        frame.add(panelInput, BorderLayout.SOUTH);
        frame.pack();
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        frame.setVisible(true);
    }


}
