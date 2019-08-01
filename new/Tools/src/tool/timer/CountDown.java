package tool.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.FeatureDescriptor;

/**
 * 倒计时软件
 */

public class CountDown {
    private final static int NUM = 7;
    private static JPanel panelShow = new JPanel();
    private static JLabel[] timeJLabels = new JLabel[NUM];//文本
    private static JLabel[] labels = new JLabel[]{
            new JLabel("1　　靈　　"),
            new JLabel("2　廣　覽　"),
            new JLabel("3　川　布　"),
            new JLabel("4　晃　丘　"),
            new JLabel("5　別　類　"),
            new JLabel("6　別　類　"),
            new JLabel("7　警　告　"),
    };

    static {
        GridLayout gridLayout = new GridLayout(NUM, 2);
        panelShow.setLayout(gridLayout);
        for (int i = 0; i < NUM; i++) {
            timeJLabels[i] = new JLabel("");
            timeJLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
            timeJLabels[i].setFont(new Font("kaiti",0,24));
            timeJLabels[i].setForeground(Color.RED);


            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setBackground(Color.pink);
            labels[i].setFont(new Font("kaiti",0,24));

            panelShow.add(labels[i]);
            panelShow.add(timeJLabels[i]);
        }

        panelShow.setBackground(Color.white);
    }


    private static JPanel panelInput = new JPanel();
    private static boolean panelInputVisible = true;
    private static JTextField textFieldInput = new JTextField(10);

    static {
        textFieldInput.setEnabled(true);
        textFieldInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String input = textFieldInput.getText();
                    if(input.equals("exit")||input.equals("quit")){
                        System.exit(0);
                    }

                    textFieldInput.setText("");
                    try {
                        final String[] s = input.split(" ");
                        int num = Integer.valueOf(s[0])-1;
                        int second = (int)(Double.valueOf(s[1]) * 60);
                        new Thread(new TimeCounterThread(num, second, timeJLabels)).start();
                    } catch (Exception ee) {
//                        ee.printStackTrace();
                        timeJLabels[NUM - 1].setText(input);
                    }

                }
            }
        });

        panelInput.setBackground(Color.WHITE);
        panelInput.add(textFieldInput);
        panelInput.setVisible(panelInputVisible);
    }

    //window
    private static JFrame frame;
    private static Point originPoint = new Point();
    private static long clickTime = 0;

    static {
        frame = new JFrame();
        frame.add(panelShow);
        frame.add(panelInput, BorderLayout.SOUTH);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                originPoint.x = e.getX();
                originPoint.y = e.getY();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                final long currentTimeMillis = System.currentTimeMillis();
//                System.out.println("currentTimeMillis = " + currentTimeMillis);
                if(Math.abs(currentTimeMillis-clickTime)<500){
//                    System.out.println("e = " + e);
                    if(panelInputVisible){
                        panelInputVisible=false;
                    }else {
                        panelInputVisible=true;
                    }
                    panelInput.setVisible(panelInputVisible);
                }
                clickTime=currentTimeMillis;
            }
        });

        frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = frame.getLocation();
                frame.setLocation(p.x + e.getX() - originPoint.x, p.y + e.getY()- originPoint.y);

            }
        });

        frame.dispose();
        frame.setUndecorated(true);
        frame.setLocation(400, 200);
        frame.pack();
    }

    public static void main(String[] args) {
        frame.setVisible(true);
    }


}
