package zrx.com.others;

import org.junit.Test;

/**
 * Description
 * x==(x=2)
 * <p>
 * Data
 * 2019/12/4 16:46
 *
 * @author zrx
 * @version 1.0
 */

public class EqualEqual {
    public int method(){
        int x;
        boolean b;
        x = 1;
        b = (x==(x=2));
        if(b){
            x = 3;
        }else {
            x = 4;
        }

        return x;
    }
    //public void method();
    //    Code:
    //       0: iconst_1 //int_1推送栈顶
    //       1: istore_1 //栈顶取int数，至1号本地变量
    //       2: iload_1 //1号本地变量，int推至栈顶

    //  x=1

    //       3: iconst_2 //int_2推送栈顶
    //       4: dup // 复制栈顶数字并将复制值压入栈顶
    //       5: istore_1 // 栈顶取int数，至1号本地变量

    //       6: if_icmpne     13 // 比较栈顶2个int，不等于零跳转
    //       9: iconst_1
    //      10: goto          14
    //      13: iconst_0  // int_0推送栈顶
    //      14: istore_2  //栈顶取int数，至2号本地变量

    //  ==

    //      15: iload_2  //2号本地变量，int推至栈顶
    //      16: ifeq          24  //栈顶int=0时跳转
    //      19: iconst_3
    //      20: istore_1
    //      21: goto          26
    //      24: iconst_4 //
    //      25: istore_1
    //      26: iload_1
    //      27: ireturn


    @Test
    public void test(){
        method();
    }
}
