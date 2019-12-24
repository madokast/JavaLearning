package zrx.com.DesignPatterns.CommandPattern.command;

import zrx.com.DesignPatterns.CommandPattern.CommandObjects.TV;

/**
 * Description
 * 电视机的on/off接口
 * <p>
 * Data
 * 2019/12/24 15:20
 *
 * @author zrx
 * @version 1.0
 */

public class TVOnCommand implements Commmand{

    private final TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

    @Override
    public void undo() {
        tv.off();
    }
}
