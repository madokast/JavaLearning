package madokast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class PinBall {
    //桌面寬度 高度
    private final int TABLE_WIDTH = 300;
    private final int TABLE_HIGHT = 400;

    //球拍垂直位置
    private final int RACKET_Y = 340;

    //球拍的寬度 高度
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HIGHT = 20;

    //球的大小
    private final int BALL_SIZE = 16;

    //窗口
    private Frame f =new Frame("PinBall");

    //隨機數
    Random rand = new Random();

    //小球縱向 橫向運行速度 橫向由隨機數決定方向再決定之
    private int ySpeed = 10;
    private double xyRate = rand.nextDouble()-0.5;
    private int xSpeed = (int)(ySpeed*xyRate*2);

    //小球坐標
    private int ballX = rand.nextInt(200)+20;
    private int ballY = rand.nextInt(10)+20;

    //球拍水平位置
    private int racketX = rand.nextInt(200);

    //畫圖
    private MyCanvas tableArea = new MyCanvas();

    //???
    Timer timer;

    //游戲就輸標志
    private boolean isLose = false;

    public void init(){

        //設置桌面區域最佳大小
        tableArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HIGHT));
        f.add(tableArea);

        //定義鍵盤監聽器
        KeyAdapter keyProcessor = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //左右控制球拍
                if(e.getKeyCode()==KeyEvent.VK_LEFT)
                {
                    if(racketX>0)
                        racketX -= 10;
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT)
                {
                    if(racketX<TABLE_WIDTH-RACKET_WIDTH)
                        racketX += 10;
                }

                if(e.getKeyCode()==KeyEvent.VK_S)
                    timer.stop();

                if(e.getKeyCode()==KeyEvent.VK_A)
                    timer.start();
            }


        };
        //為窗口和tableArea對象添加鍵盤監聽器
        //爲什麽前者也需要？只要畫圖器需要就行了吧？不清楚
        f.addKeyListener(keyProcessor);
        tableArea.addKeyListener(keyProcessor);

        //定義每0.1秒執行一次事件監聽器
        ActionListener taskPerformer = evt->
        {
            //小球碰壁轉向
            if(ballX<=0||ballX>=TABLE_WIDTH-BALL_SIZE)
                xSpeed=-xSpeed;

            //小球沒接住
            if(ballY>=RACKET_Y-BALL_SIZE&&
                    (ballX<racketX||ballX>racketX+RACKET_WIDTH))
            {
                timer.stop();
                isLose=true;
                tableArea.repaint();
            }
            //接住小球 或小球到達天花板
            else if(ballY<=0||
                    (ballY>=RACKET_Y-BALL_SIZE&&
                            (ballX>racketX&&ballX<=racketX+RACKET_WIDTH)))
            {
                ySpeed=-ySpeed;
            }

            //小球移動
            ballX+=xSpeed;
            ballY+=ySpeed;

            //繪圖
            tableArea.repaint();
        };

        timer = new Timer(100,taskPerformer);
        timer.start();
        f.pack();
        f.setVisible(true);

    }

    public static void main(String[] args) {
        new PinBall().init();
    }


    class MyCanvas extends Canvas{

        @Override//重寫paint
        public void paint(Graphics g) {

            //如果游戲結束
            if(isLose)
            {
                g.setColor(new Color(255,0,0));
                g.setFont(new Font("Times",Font.BOLD,30));
                g.drawString("game over!",50,200);
            }
            //游戲未結束
            else
            {
                //設置顔色 繪製小球
                g.setColor(new Color(240,140,80));
                g.fillOval(ballX,ballY,BALL_SIZE,BALL_SIZE);

                //設置顔色 繪製球拍
                g.setColor(new Color(80,80,200));
                g.fillRect(racketX,RACKET_Y,RACKET_WIDTH,RACKET_HIGHT);
            }
        }



    }
}
