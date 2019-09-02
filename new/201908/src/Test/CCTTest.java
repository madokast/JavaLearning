package Test;

public class CCTTest {
    public static void main(String[] args) {
        final int N = 241;
        int count = 0;
        for (int i = 1 ; i < 120; i++) {
            for (int j = 1; j < 120; j++) {
                int k = N - 2*(i+j);
                if(k<=0)
                    continue;

                count++;
            }
        }
        System.out.println(count);
    }
}
