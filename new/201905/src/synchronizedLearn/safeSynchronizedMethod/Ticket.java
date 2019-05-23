package synchronizedLearn.safeSynchronizedMethod;

public class Ticket {
    public static void main(String[] args) {
        Runnable r = new Window();
        System.out.println("r = " + r);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
    }
}

///home/madokast/app/jdk-12.0.1/bin/java -javaagent:/home/madokast/app/ideaJ/lib/idea_rt.jar=42887:/home/madokast/app/ideaJ/bin -Dfile.encoding=UTF-8 -classpath /home/madokast/Documents/JavaLearning/new/out/production/201905 synchronizedLearn.safeSynchronizedMethod.Ticket
//Thread-0卖出100
//Thread-0卖出99
//Thread-0卖出98
//Thread-0卖出97
//Thread-0卖出96
//Thread-0卖出95
//Thread-0卖出94
//Thread-0卖出93
//Thread-0卖出92
//Thread-0卖出91
//Thread-0卖出90
//Thread-0卖出89
//Thread-0卖出88
//Thread-0卖出87
//Thread-0卖出86
//Thread-0卖出85
//Thread-0卖出84
//Thread-0卖出83
//Thread-0卖出82
//Thread-0卖出81
//Thread-0卖出80
//Thread-0卖出79
//Thread-0卖出78
//Thread-0卖出77
//Thread-2卖出76
//Thread-2卖出75
//Thread-2卖出74
//Thread-2卖出73
//Thread-2卖出72
//Thread-2卖出71
//Thread-2卖出70
//Thread-2卖出69
//Thread-2卖出68
//Thread-2卖出67
//Thread-2卖出66
//Thread-2卖出65
//Thread-2卖出64
//Thread-1卖出63
//Thread-1卖出62
//Thread-1卖出61
//Thread-1卖出60
//Thread-1卖出59
//Thread-1卖出58
//Thread-1卖出57
//Thread-1卖出56
//Thread-1卖出55
//Thread-1卖出54
//Thread-1卖出53
//Thread-1卖出52
//Thread-1卖出51
//Thread-1卖出50
//Thread-2卖出49
//Thread-2卖出48
//Thread-0卖出47
//Thread-0卖出46
//Thread-0卖出45
//Thread-0卖出44
//Thread-0卖出43
//Thread-0卖出42
//Thread-0卖出41
//Thread-0卖出40
//Thread-0卖出39
//Thread-0卖出38
//Thread-0卖出37
//Thread-0卖出36
//Thread-0卖出35
//Thread-0卖出34
//Thread-0卖出33
//Thread-0卖出32
//Thread-0卖出31
//Thread-0卖出30
//Thread-0卖出29
//Thread-2卖出28
//Thread-2卖出27
//Thread-2卖出26
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
//Thread-0卖出11
//Thread-0卖出10
//Thread-0卖出9
//Thread-2卖出8
//Thread-2卖出7
//Thread-2卖出6
//Thread-2卖出5
//Thread-2卖出4
//Thread-2卖出3
//Thread-2卖出2
//Thread-2卖出1
