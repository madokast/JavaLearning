package zrx.com.DesignPatterns.CommandPattern.command;

import zrx.com.DesignPatterns.CommandPattern.Remoter;
import zrx.com.MultiThread.MyTools;

/**
 * Description
 * 宏命令
 * <p>
 * Data
 * 2019/12/24 15:42
 *
 * @author zrx
 * @version 1.0
 */

public class MetaCommand implements Commmand{
    private Remoter remoter = new Remoter();

    @Override
    public void execute() {
        MyTools.printMsgWithThreadAndTime("开始执行宏命令-----------");

        remoter.tvOn();
        remoter.TVVolumeUp();
        remoter.TVVolumeUp();

        remoter.lightOn();
        remoter.lightColor();
        remoter.lightColor();
        remoter.lightColor();

        MyTools.printMsgWithThreadAndTime("-----------宏命令执行完成");
    }

    @Override
    public void undo() {
        MyTools.printMsgWithThreadAndTime("开始取消宏命令-----------");

        for (int i = 0; i < 7; i++) {
            remoter.undo();
        }

        MyTools.printMsgWithThreadAndTime("-----------宏命令取消完成");
    }
}
