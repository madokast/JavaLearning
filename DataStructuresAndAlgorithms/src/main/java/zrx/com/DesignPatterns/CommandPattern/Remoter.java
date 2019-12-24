package zrx.com.DesignPatterns.CommandPattern;

import zrx.com.DesignPatterns.CommandPattern.CommandObjects.Light;
import zrx.com.DesignPatterns.CommandPattern.CommandObjects.TV;
import zrx.com.DesignPatterns.CommandPattern.command.*;
import zrx.com.MultiThread.MyTools;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Description
 * 遥控器
 * <p>
 * Data
 * 2019/12/24 15:26
 *
 * @author zrx
 * @version 1.0
 */

public class Remoter {
    private Commmand[] commmands = new Commmand[4];
    {
        final TV tv = new TV();
        commmands[0] = new TVOnCommand(tv);
        commmands[1] = new TVVolumeCommand(tv);

        final Light light = new Light();
        commmands[2] = new LightOnCommand(light);
        commmands[3] = new LightColorCommand(light);
    }

    private Stack<Commmand> commmandStack = new Stack<>();

    public void tvOn(){
        commmands[0].execute();
        commmandStack.push(commmands[0]);
    }

    public void lightOn(){
        commmands[2].execute();
        commmandStack.push(commmands[2]);
    }

    public void TVVolumeUp(){
        commmands[1].execute();
        commmandStack.push(commmands[1]);
    }

    public void lightColor(){
        commmands[3].execute();
        commmandStack.push(commmands[3]);
    }


    public void undo(){
        try {
            Commmand commmand = commmandStack.pop();
            commmand.undo();
        }catch (EmptyStackException e){
            MyTools.printMsgWithThreadAndTime("命令队列为空，无法继续撤销");
        }
    }
}
