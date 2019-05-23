package thread;

import java.util.Map;

public class Cinema {
    public static void main(String[] args) {
        Thread kaisatu1 = new Thread(new KaiSatu());
        Thread kaisatu2 = new Thread(new KaiSatu());
        Thread kaisatu3 = new Thread(new KaiSatu());

        kaisatu1.setName("kaisatu1");
        kaisatu2.setName("kaisatu2");
        kaisatu3.setName("kaisatu3");


        kaisatu1.start();
        kaisatu2.start();
        kaisatu3.start();

        try {
            kaisatu1.join();
            kaisatu2.join();
            kaisatu3.join();
        }catch (Exception e){e.printStackTrace();}


        System.out.println("本电影院售票结束，剩余票数为"+Ticket.getNum());
        Ticket.reportAll();
    }


}

//D:\app\jdk-12.0.1\bin\java.exe "-javaagent:D:\app\IntelliJ IDEA 2018.3.4\lib\idea_rt.jar=58182:D:\app\IntelliJ IDEA 2018.3.4\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\JavaLearning\new\out\production\201905 thread.Cinema
//Picked up JAVA_TOOL_OPTIONS: -Duser.language=en
//kaisatu2卖出1张票，还剩98
//kaisatu3卖出1张票，还剩97
//kaisatu1卖出1张票，还剩98
//kaisatu1卖出1张票，还剩96
//kaisatu3卖出1张票，还剩95
//kaisatu2卖出1张票，还剩94
//kaisatu1卖出1张票，还剩93
//kaisatu3卖出1张票，还剩92
//kaisatu2卖出1张票，还剩91
//kaisatu1卖出1张票，还剩90
//kaisatu3卖出1张票，还剩89
//kaisatu2卖出1张票，还剩88
//kaisatu1卖出1张票，还剩87
//kaisatu2卖出1张票，还剩86
//kaisatu3卖出1张票，还剩85
//kaisatu1卖出1张票，还剩84
//kaisatu3卖出1张票，还剩83
//kaisatu2卖出1张票，还剩82
//kaisatu1卖出1张票，还剩81
//kaisatu3卖出1张票，还剩80
//kaisatu2卖出1张票，还剩79
//kaisatu1卖出1张票，还剩78
//kaisatu3卖出1张票，还剩77
//kaisatu2卖出1张票，还剩76
//kaisatu1卖出1张票，还剩75
//kaisatu2卖出1张票，还剩74
//kaisatu3卖出1张票，还剩73
//kaisatu1卖出1张票，还剩72
//kaisatu2卖出1张票，还剩71
//kaisatu3卖出1张票，还剩70
//kaisatu1卖出1张票，还剩69
//kaisatu2卖出1张票，还剩68
//kaisatu3卖出1张票，还剩67
//kaisatu1卖出1张票，还剩66
//kaisatu2卖出1张票，还剩65
//kaisatu3卖出1张票，还剩64
//kaisatu1卖出1张票，还剩63
//kaisatu2卖出1张票，还剩62
//kaisatu3卖出1张票，还剩61
//kaisatu2卖出1张票，还剩60
//kaisatu1卖出1张票，还剩59
//kaisatu3卖出1张票，还剩58
//kaisatu2卖出1张票，还剩57
//kaisatu1卖出1张票，还剩56
//kaisatu3卖出1张票，还剩55
//kaisatu2卖出1张票，还剩54
//kaisatu1卖出1张票，还剩53
//kaisatu3卖出1张票，还剩52
//kaisatu2卖出1张票，还剩51
//kaisatu1卖出1张票，还剩50
//kaisatu3卖出1张票，还剩49
//kaisatu2卖出1张票，还剩48
//kaisatu1卖出1张票，还剩47
//kaisatu3卖出1张票，还剩46
//kaisatu2卖出1张票，还剩45
//kaisatu1卖出1张票，还剩44
//kaisatu3卖出1张票，还剩43
//kaisatu2卖出1张票，还剩42
//kaisatu1卖出1张票，还剩41
//kaisatu3卖出1张票，还剩40
//kaisatu2卖出1张票，还剩39
//kaisatu3卖出1张票，还剩38
//kaisatu1卖出1张票，还剩37
//kaisatu2卖出1张票，还剩36
//kaisatu3卖出1张票，还剩35
//kaisatu1卖出1张票，还剩34
//kaisatu2卖出1张票，还剩33
//kaisatu3卖出1张票，还剩32
//kaisatu1卖出1张票，还剩31
//kaisatu2卖出1张票，还剩30
//kaisatu3卖出1张票，还剩29
//kaisatu1卖出1张票，还剩28
//kaisatu2卖出1张票，还剩27
//kaisatu3卖出1张票，还剩26
//kaisatu1卖出1张票，还剩25
//kaisatu2卖出1张票，还剩24
//kaisatu3卖出1张票，还剩23
//kaisatu1卖出1张票，还剩22
//kaisatu2卖出1张票，还剩21
//kaisatu3卖出1张票，还剩20
//kaisatu1卖出1张票，还剩19
//kaisatu2卖出1张票，还剩18
//kaisatu3卖出1张票，还剩17
//kaisatu1卖出1张票，还剩16
//kaisatu2卖出1张票，还剩15
//kaisatu1卖出1张票，还剩14
//kaisatu3卖出1张票，还剩13
//kaisatu2卖出1张票，还剩12
//kaisatu1卖出1张票，还剩11
//kaisatu3卖出1张票，还剩10
//kaisatu2卖出1张票，还剩9
//kaisatu1卖出1张票，还剩8
//kaisatu3卖出1张票，还剩7
//kaisatu2卖出1张票，还剩6
//kaisatu1卖出1张票，还剩5
//kaisatu3卖出1张票，还剩4
//kaisatu2卖出1张票，还剩3
//kaisatu1卖出1张票，还剩2
//kaisatu3卖出1张票，还剩1
//kaisatu2卖出1张票，还剩0
//kaisatu2售完
//kaisatu3卖出1张票，还剩-1
//kaisatu3售完
//kaisatu1卖出1张票，还剩-2
//kaisatu1售完
//本电影院售票结束，剩余票数为-2
//窗口kaisatu1售出34张票
//窗口kaisatu3售出34张票
//窗口kaisatu2售出34张票
//
//Process finished with exit code 0
