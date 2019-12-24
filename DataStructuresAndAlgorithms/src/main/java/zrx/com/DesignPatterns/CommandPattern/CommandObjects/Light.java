package zrx.com.DesignPatterns.CommandPattern.CommandObjects;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 命令对象
 * 灯
 * 可以开关
 * 可以调整颜色
 * <p>
 * Data
 * 2019/12/24 15:10
 *
 * @author zrx
 * @version 1.0
 */

public class Light {
    public void on(){
        MyTools.printMsgWithThreadAndTime("打开电灯");
    }

    public void off(){
        MyTools.printMsgWithThreadAndTime("关闭电灯");
    }

    private String[] colors = {"red","blue","yellow"};
    private int colorIndex = 0;

    public void rightChangeColor(){
        String per = colors[colorIndex];
        colorIndex++;
        colorIndex%=colors.length;
        String cur = colors[colorIndex];
        MyTools.printMsgWithThreadAndTime("电灯颜色从"+per+"调整到"+cur);
    }

    public void leftChangeColor(){
        String per = colors[colorIndex];
        colorIndex--;
        colorIndex+=colors.length;
        colorIndex%=colors.length;
        String cur = colors[colorIndex];
        MyTools.printMsgWithThreadAndTime("电灯颜色从"+per+"调整到"+cur);
    }

}
