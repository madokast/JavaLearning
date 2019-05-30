package WaitAndNotify;

import java.util.zip.CheckedInputStream;

public class Tets {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        new BaoZiPu(baoZi).start();
        new ChiHuo(baoZi).start();


    }
}

//终于写好了
///home/madokast/app/jdk-12.0.1/bin/java -javaagent:/home/madokast/app/ideaJ/lib/idea_rt.jar=33245:/home/madokast/app/ideaJ/bin -Dfile.encoding=UTF-8 -classpath /home/madokast/Documents/JavaLearning/new/out/production/201905 WaitAndNotify.Tets
//正在生产123321
//包子已经生产好了123321
//吃包子123321
//包子吃完了，请开始生产
//正在生产abccda
//包子已经生产好了abccda
//吃包子abccda
//包子吃完了，请开始生产
//正在生产123321
//包子已经生产好了123321
//吃包子123321
//包子吃完了，请开始生产
//正在生产abccda
//包子已经生产好了abccda
//吃包子abccda
//包子吃完了，请开始生产
//正在生产123321
//包子已经生产好了123321
//吃包子123321
//包子吃完了，请开始生产
//正在生产abccda
//包子已经生产好了abccda
//吃包子abccda
//包子吃完了，请开始生产
//正在生产123321
//包子已经生产好了123321
//吃包子123321
//包子吃完了，请开始生产
//正在生产abccda
//包子已经生产好了abccda
//吃包子abccda
//包子吃完了，请开始生产
//正在生产123321
//包子已经生产好了123321
//吃包子123321
//包子吃完了，请开始生产
//正在生产abccda
//
//Process finished with exit code 130 (interrupted by signal 2: SIGINT)
