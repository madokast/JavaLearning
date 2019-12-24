package zrx.com.DesignPatterns.CommandPattern.CommandObjects;

import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 命令对象，电视机
 * <p>
 * Data
 * 2019/12/24 15:08
 *
 * @author zrx
 * @version 1.0
 */

public class TV {
    public void on(){
        MyTools.printMsgWithThreadAndTime("打开电视机");
    }

    public void off(){
        MyTools.printMsgWithThreadAndTime("打开电视机关闭");
    }

    private int volume = 10;

    public void volumeUp(){
        volume++;
        MyTools.printMsgWithThreadAndTime("电视机增大至" + volume);
    }

    public void volumeDown(){
        volume--;
        MyTools.printMsgWithThreadAndTime("电视机减小至" + volume);
    }
}
