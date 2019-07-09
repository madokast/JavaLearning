package OwnTest;

import javax.xml.stream.FactoryConfigurationError;
import java.lang.management.BufferPoolMXBean;

public class 背包问题01 {
    public static void main(String[] args) {
        Good g1 = new Good(15, 30);
        Good g2 = new Good(10, 18);
        Good g3 = new Good(10, 17);
        Good[] goods = new Good[]{g1, g2, g3};

        int w = 22;

//        decisionTree(4);
        System.out.println(solve(w, goods));
    }

    /**
     * 决策树
     * @param n 深度
     */
    public static void decisionTree(int n) {
        boolean[] Y = new boolean[n];
        int k = 0;//当前处理的问题
        while (k < n) {
            Y[k] = true;
            k++;
        }
        k = n - 1;
        while (true) {
            print(Y);
            while (!Y[k]) {
                k--;
                if (k < 0)
                    return;
            }
            if (k < 0)
                return;
            else {
                Y[k] = false;
                k++;
                while (k < n) {
                    Y[k] = true;
                    k++;
                }
                k = n - 1;
            }
        }
    }

    /**
     * 打印决策树
     * @param Y 布尔串
     */
    public static void print(boolean[] Y) {
        System.out.print("[");
        for (int i = 0; i < Y.length; i++) {
            if (Y[i]) {
                System.out.print("放入第" + i + "件物品;");
            } else {
                System.out.print("不放第" + i + "件物品;");
            }
        }
        System.out.print("]\n");
    }

    private static int solve(int w, Good[] goods) {
        int n = goods.length;
        boolean[] Y = new boolean[n];
        int k = 0;
        int cw = 0;
        int cv = 0;
        int bv = 0;
        while (true) {
            while (k < n && (cw + goods[k].weigth) < w) {
                Y[k] = true;
                cw += goods[k].weigth;
                cv += goods[k].value;
                k++;
            }
            print(Y);
            System.out.println("cw cv=" + cw + " " + cv);
            if (cv > bv) {
                bv = cv;
            }
            if(k==n){
                System.out.println("out at 0");
                return bv;
            }

            k=n-1;
            while (!Y[k]) {
                k--;
                if (k == -1){
                    System.out.println("out at 1");
                    return bv;
                }
            }
            Y[k] = false;
            cv-=goods[k].value;
            cw-=goods[k].weigth;
            k++;
        }
    }

    /**
     * 物品内部类
     */
    private static class Good {
        /**
         * 物品
         */
        public int weigth;
        public int value;

        public Good(int weigth, int value) {
            this.weigth = weigth;
            this.value = value;
        }
    }
}
