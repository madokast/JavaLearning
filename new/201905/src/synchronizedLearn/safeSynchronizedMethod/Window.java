package synchronizedLearn.safeSynchronizedMethod;

/**
 * 同步方法
 * 锁对象就是本线程的实现类对象
 *
 * 也就是说
 *     synchronized void f(){aaaa}
 *
 *   ==
 *
 *     void f(){
 *         synchronized(this){aaaa}
 *     }
 */

public class Window implements Runnable {
    private int ticket = 100;

    @Override
    public void run(){
        while (true){
            sell2();
        }
    }

    public synchronized void sell1(){
        if(ticket>0){
            try {
                Thread.currentThread().sleep(10);
            }catch (Exception e){e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"卖出"+ticket);
            ticket--;
        }
    }

    public /*synchronized*/ void sell2(){
        synchronized(this){
            if(ticket>0){
                try {
                    Thread.currentThread().sleep(10);
                }catch (Exception e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"卖出"+ticket);
                ticket--;
            }
        }
    }
}

///home/madokast/app/jdk-12.0.1/bin/java -javaagent:/home/madokast/app/ideaJ/lib/idea_rt.jar=33153:/home/madokast/app/ideaJ/bin -Dfile.encoding=UTF-8 -classpath /home/madokast/Documents/JavaLearning/new/out/production/201905 synchronizedLearn.safeSynchronizedMethod.Ticket
//r = synchronizedLearn.safeSynchronizedMethod.Window@31befd9f
//Thread-0卖出100
//Thread-0卖出99
//Thread-0卖出98
//Thread-0卖出97
//Thread-0卖出96
//Thread-2卖出95
//Thread-2卖出94
//Thread-2卖出93
//Thread-2卖出92
//Thread-2卖出91
//Thread-2卖出90
//Thread-2卖出89
//Thread-2卖出88
//Thread-2卖出87
//Thread-2卖出86
//Thread-2卖出85
//Thread-2卖出84
//Thread-2卖出83
//Thread-2卖出82
//Thread-2卖出81
//Thread-2卖出80
//Thread-2卖出79
//Thread-2卖出78
//Thread-2卖出77
//Thread-2卖出76
//Thread-2卖出75
//Thread-2卖出74
//Thread-1卖出73
//Thread-1卖出72
//Thread-1卖出71
//Thread-1卖出70
//Thread-1卖出69
//Thread-1卖出68
//Thread-1卖出67
//Thread-1卖出66
//Thread-1卖出65
//Thread-1卖出64
//Thread-1卖出63
//Thread-1卖出62
//Thread-1卖出61
//Thread-2卖出60
//Thread-2卖出59
//Thread-2卖出58
//Thread-2卖出57
//Thread-2卖出56
//Thread-0卖出55
//Thread-0卖出54
//Thread-0卖出53
//Thread-0卖出52
//Thread-0卖出51
//Thread-0卖出50
//Thread-0卖出49
//Thread-0卖出48
//Thread-0卖出47
//Thread-0卖出46
//Thread-0卖出45
//Thread-0卖出44
//Thread-0卖出43
//Thread-0卖出42
//Thread-0卖出41
//Thread-0卖出40
//Thread-2卖出39
//Thread-2卖出38
//Thread-2卖出37
//Thread-1卖出36
//Thread-1卖出35
//Thread-1卖出34
//Thread-1卖出33
//Thread-1卖出32
//Thread-1卖出31
//Thread-1卖出30
//Thread-1卖出29
//Thread-1卖出28
//Thread-1卖出27
//Thread-1卖出26
//Thread-1卖出25
//Thread-1卖出24
//Thread-1卖出23
//Thread-1卖出22
//Thread-1卖出21
//Thread-1卖出20
//Thread-1卖出19
//Thread-1卖出18
//Thread-1卖出17
//Thread-1卖出16
//Thread-1卖出15
//Thread-2卖出14
//Thread-2卖出13
//Thread-2卖出12
//Thread-2卖出11
//Thread-2卖出10
//Thread-2卖出9
//Thread-2卖出8
//Thread-2卖出7
//Thread-2卖出6
//Thread-2卖出5
//Thread-0卖出4
//Thread-0卖出3
//Thread-0卖出2
//Thread-0卖出1
