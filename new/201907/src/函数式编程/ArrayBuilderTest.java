package 函数式编程;

public class ArrayBuilderTest {
    public static void main(String[] args) {
        final int[] ints = arrayBuilder(5, len -> new int[len]);
        System.out.println("ints.length = " + ints.length);

        final int[] ints1 = arrayBuilder(10, int[]::new);
        System.out.println("ints1.length = " + ints1.length);
    }

    public static int[] arrayBuilder(int len,ArrayBuilder ab){
        return ab.builder(len);
    }
}
