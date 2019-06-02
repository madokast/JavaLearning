package linuxTool;

import linuxTool.GUItool.ImagePreloading;
import linuxTool.GUItool.Splash;
import linuxTool.myShell.Shell;
import linuxTool.tool.StringTool;

/**
 * Linux小工具
 * 专用于多任务快捷键，尤其是那种要打开一个大软件的快捷键，按了半天没有反应，可以蹦出splash判断这个快捷键是否生效
 * <p>
 * 实例——打开ideaJ ，将快捷建命令改为：
 * java -classpath /home/madokast/Documents/JavaLearning/linuxTools/out/production/linuxTools linuxTool.Main --splash /home/madokast/Documents/JavaLearning/linuxTools/image/kuro.png 10000 --shells -shell  /home/madokast/app/ideaIC-2019.1.3-jbr11/idea-IC-191.7479.19/bin/idea.sh
 */
public class Main {
    public static void main(String[] args) {
        /**
         * test
         */
//        args = new String[]{"--splash","/home/madokast/Documents/JavaLearning/linuxTools/image/kuro.png","2000"};
//        args = new String[]{"--splash"};

        /**
         * preload picture
         */
        new Thread(()-> ImagePreloading.preload()).start();


        /**
         * 零参数 显示如何获得帮助
         */
        if (args.length == 0) {
            System.out.println("Linux 小工具，可同时执行多条命令～");
            System.out.println("  -h for help");
            System.exit(0);
        }

        /**
         * 显示帮助
         */
        if (args[0].equals("-h")) {
            System.out.println("Linux 小工具，可同时执行多条命令～");
            System.out.println("  --splash [imageDir] [duration/ms] 快速显示图片。参数：图片地址和显示时长。可顺序空");
            System.out.println("  --shells [-shell ...]* 顺序执行多条shell指令，每条shell指令用-shell开头，数目不限");
            System.exit(0);
        }

        /**
         * 命令识别
         */
        process(args, "--");
    }

    /**
     * 命令识别
     * 仅仅是按照 "--" 开头的字符串来识别命令，不检查命令是否正确
     * 注意每识别一条命令，让subProcess执行
     * <p>
     * 例如 --a 1 2 --b 3 --c
     * 0  1 2 3   4 5     length=6
     * 应当发现三个命令：
     * 起点  参数长度
     * 1     2
     * 3     1
     * 5     0
     *
     * @param args main函数传参
     */
    private static void process(final String[] args, String commandSeparator) {
        int currentCommand = -1;
        int nextCommand = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith(commandSeparator)) {

                nextCommand = i;

                if (currentCommand != -1) {
                    subProcess(args, currentCommand, nextCommand - currentCommand - 1);
                }

                currentCommand = nextCommand;
            }
        }

        //执行最后的命令
        if (nextCommand != -1) {
            subProcess(args, nextCommand, args.length - nextCommand - 1);
        } else {
            System.err.println("错误：没有收到任何命令。请在命令前加--");
        }
    }

    /**
     * 执行命令，同时负责检查命令是否错误（不检查命令参数是否合理）
     * !!!注意交由新线程执行，以免阻碍下一条命令
     *
     * @param args   main函数传参
     * @param start  命令起点，不包含命令本身
     * @param length 命令参数长度
     */
    private static void subProcess(final String[] args, int start, int length) {
        switch (args[start]) {
            case "--splash":
                threadRun(() -> splash(args, start, length));
                break;
            case "--shells":
                threadRun(() -> shells(args, start, length));
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = start; i <= start + length; i++) {
                    stringBuilder.append(" " + args[i]);
                }
                System.err.println("无法识别指令：" + stringBuilder.toString());
        }
    }

    /**
     * 快速显示图片
     * [imageDir] [duration/ms] 快速显示图片，参数：图片地址和显示时长。可顺序空
     *
     * @param args   main函数传参
     * @param start  本函数所用main参数--字符串数组的起点
     * @param length 本函数可是使用的main参数--字符串数组的长度，从起点开始计算
     */
    private static void splash(final String[] args, int start, int length) {
        final int DURATION = 1000;
        switch (length) {
            case 0:
                Splash.exhibit(null, DURATION);
                break;
            case 1:
                Splash.exhibit(args[start + 1], DURATION);
                break;
            case 2:
                Splash.exhibit(args[start + 1], StringTool.safeString2int(DURATION, args[start + 2]));
                break;
            default:
                System.err.println("警告：--splash命令参数过多，仅处理前两个参数");
                Splash.exhibit(args[start + 1], StringTool.safeString2int(DURATION, args[start + 2]));
                break;
        }
    }

    /**
     * --shells [-shell ...]* 顺序执行多条shell指令，每条shell指令用-shell开头，数目不限
     *
     * @param args   main函数传参
     * @param start  本函数所用main参数--字符串数组的起点
     * @param length 本函数可是使用的main参数--字符串数组的长度，从起点开始计算
     */
    private static void shells(final String[] args, int start, int length) {
        if (length == 0) {
            System.err.println("警告：--shells参数不能为空");
            return;
        }

        int currentCommand = -1;
        int nextCommand = -1;
        for (int i = start + 1; i <= start + length; i++) {
            if (args[i].startsWith("-shell")) {

                nextCommand = i;

                if (currentCommand != -1) {
                    safeShell(args, currentCommand, nextCommand - currentCommand - 1);
                }

                currentCommand = nextCommand;
            }
        }

        //执行最后的命令
        if (nextCommand != -1) {
            safeShell(args, nextCommand, start + length - nextCommand);
        } else {
            System.err.println("错误：--shells没有收到任何shell命令。请在shell命令前加-shell");
        }
    }


    /**
     * dir cd绝对位置
     */
    private static String dir = null;

    /**
     * 安全的执行shell
     * 说是安全，实际上就是串起来
     */
    private static void safeShell(final String[] args, int start, int length) {
//        if(!args[start].equals("-shell")){
//            System.err.println("警告：--shells后子命令只能以-shell开头,"+args[start]+"非法");
//            return;
//        }

        if (length == 0) {
            System.err.println("警告：-shell参数不能为空");
            return;
        }

        if (length == 2 && args[start + 1].equals("cd")) {
            dir = args[start + 2];
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start + 1; i <= start + length; i++) {
            stringBuilder.append(args[i]).append(' ');
        }
        System.out.println("将要执行的shell指令是 = " + stringBuilder.toString());
        new Shell(dir).exec(stringBuilder.toString());
    }

    /**
     * 新建线程运行
     * 应该没必要使用线程池
     *
     * @param runnable 要完成的命令
     */
    private final static void threadRun(Runnable runnable) {
        new Thread(runnable).start();
    }
}
