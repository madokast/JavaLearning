package zrx.com.DesignPatterns.CommandPattern.command;

import zrx.com.DesignPatterns.CommandPattern.CommandObjects.Light;

/**
 * Description
 * 电灯颜色命令
 * <p>
 * Data
 * 2019/12/24 15:24
 *
 * @author zrx
 * @version 1.0
 */

public class LightColorCommand implements Commmand{
    private final Light light;

    public LightColorCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.rightChangeColor();
    }

    @Override
    public void undo() {
        light.leftChangeColor();
    }
}
