package OwnTest;

import java.util.Stack;

/**
 * 出栈序列问题
 */

public class StackList {
    public static void main(String[] args) {
        System.out.println(isStackList(3, new int[]{0, 1, 2}));
        System.out.println(isStackList(3, new int[]{1, 0, 2}));
        System.out.println(isStackList(3, new int[]{2, 0, 1}));
    }


    private static boolean isStackList(int n,int[] arr){
        Stack<Integer> s = new Stack<>();
        int current = 0;
        for (int e :arr) {
            if(s.empty()){
                while (current!=e){
                    if(current>=n)
                        return false;
                    s.push(current);
                    current++;
                }
                current++;
            }else{
                int t = s.pop();
                if(t==e)
                    continue;
                else{
                    s.push(t);
                    while (current!=e){
                        if(current>=n)
                            return false;
                        s.push(current);
                        current++;
                    }
                    current++;
                }
            }
        }

        return true;

    }
}
