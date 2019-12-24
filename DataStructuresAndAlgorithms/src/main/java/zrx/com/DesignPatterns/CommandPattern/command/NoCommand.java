package zrx.com.DesignPatterns.CommandPattern.command;

/**
 * Description
 * 无命令，防止NPE
 * <p>
 * Data
 * 2019/12/24 15:25
 *
 * @author zrx
 * @version 1.0
 */

public class NoCommand implements Commmand {
    public NoCommand() {
        super();
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
