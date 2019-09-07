package learn.binTree;

import javax.imageio.stream.IIOByteBuffer;

/**
 * 八皇后问题
 */

public final class EightQueen {
    // 行列的取值: 1 2 3 4 5 6 7 8
    final int N = 4;
    final int[] x = new int[N + 1];//棋盘 x[i]表示:第i行的皇后放在了x[i]列

    public void seekAnswer() {
        init(x);
        int currentLine = 1;
        int currentRow = 1;
        while (true) {
//            System.out.println("----------");
//            printAns(x);
            currentRow = put(x, currentLine);
//            System.out.println(currentLine+" "+currentRow);
            if (currentRow == -1) {
                //currentLine 无法拜访
                currentLine = back(x, currentLine);
//                System.out.println("back "+currentLine);
                if(currentLine==-1){
                    //回溯失败
                    break;//退出循环
                }else{
                    //回溯成功
                    clear(x,currentLine+1);
                }
            }else {
                //成功在currentLine摆放到了currentRow
                if(currentLine==N){
                    //得到了解
                    printAns(x);
                    //回溯
                    currentLine = back(x, currentLine);
                    if(currentLine==-1)
                        break;
                    else {
                        clear(x,currentLine+1);
                    }
                }else {
                    //还没到最后一行,继续
                    currentLine+=1;
                }
            }
        }
    }

    private void init(int[] x) {
        for (int i = 1; i <= N; i++) {
            x[i] = 0;
        }
    }

    private void clear(int[] x,int i){
        for (int j = i; j <= N; j++) {
            x[j] = 0;
        }
    }

    /**
     * 尝试在第i行摆放,若i行已摆放,则尝试往后摆
     * 返回真实摆放的位置
     * 若无法拜访,返回-1
     */
    private int put(int[] x, int i) {
        for (int j = x[i] + 1; j <= N; j++) {
            x[i] = j;
            if (check(x, i))
                return j;
        }

        return -1;
    }

    /**
     * 回溯 第i行发生了冲突,且i行无法继续放
     * 返回应调整的行数
     * <p>
     * 返回-1 回溯失败,此时应输出结果了
     */
    private int back(int[] x, int i) {
        for (int j = i - 1; j >= 1; j--) {
            if (x[j] != N)
                return j;
        }

        return -1;
    }

    /**
     * 最新的皇后放在了i行
     * true--不冲突
     */
    private boolean check(final int[] x, int i) {
        for (int k = 1; k < i; k++) {
            //从第一行开始检查冲突
            if (x[i] == x[k]) {
                return false;
            }
            if (Math.abs(x[i] - x[k]) == Math.abs(i - k)) {
                return false;
            }

        }

        return true;
    }

    private void printAns(int[] x) {
        for (int i = 1; i <= N; i++) {
            if(x[i]==0){
                printZeros(N);
                System.out.println();
            }else {
                printZeros(x[i] - 1);
                printOne();
                printZeros(N - x[i]);
                System.out.println();
            }


        }
        System.out.println("-------------");
    }

    private void printZeros(int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(0);
        }
    }

    private void printOne() {
        System.out.print(1);
    }

    public static void main(String[] args) {
        final EightQueen eightQueen = new EightQueen();
        eightQueen.seekAnswer();
    }

}
