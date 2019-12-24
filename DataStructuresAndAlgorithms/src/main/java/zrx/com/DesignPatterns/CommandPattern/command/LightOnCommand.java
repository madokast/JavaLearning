package zrx.com.DesignPatterns.CommandPattern.command;

import zrx.com.DesignPatterns.CommandPattern.CommandObjects.Light;

/**
 * Description
 * 电灯开关命令
 * <p>
 * Data
 * 2019/12/24 15:23
 *
 * @author zrx
 * @version 1.0
 */

public class LightOnCommand implements Commmand{
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
