package zrx.com.DesignPatterns.CommandPattern.command;

import zrx.com.DesignPatterns.CommandPattern.CommandObjects.TV;

/**
 * Description
 * 电视机音量命令
 * <p>
 * Data
 * 2019/12/24 15:22
 *
 * @author zrx
 * @version 1.0
 */

public class TVVolumeCommand implements Commmand{
    private final TV tv;

    public TVVolumeCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.volumeUp();
    }

    @Override
    public void undo() {
        tv.volumeDown();
    }
}
