import java.time.Year;
import java.util.PropertyResourceBundle;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs70().climbStairs(45));
    }

    public int climbStairs2(int n){
        return 0;
    }

    int[] temp = new int[100];
    {
        temp[1]=1;
        temp[2]=2;
    }

    public int climbStairs(int n) {
        if(temp[n]!=0)
            return temp[n];

        temp[n] = climbStairs(n-1)+climbStairs(n-2);

        return temp[n];
    }
}
