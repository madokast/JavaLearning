package Collection;

public class Varargs {
    public static void main(String[] args) {
        System.out.println("max = " + max());
        System.out.println("max(1) = " + max(1));
        System.out.println("max(2,3,4,5) = " + max(2,3,4,5));
        //D:\app\jdk-12.0.1\bin\java.exe "-javaagent:D:\app\IntelliJ IDEA Community Edition 2019.1.1\lib\idea_rt.jar=50490:D:\app\IntelliJ IDEA Community Edition 2019.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\GitHub\JavaLearning\new\out\production\201905 Collection.Varargs
        //max = -2147483648
        //max(1) = 1
        //max(2,3,4,5) = 5
        //
        //Process finished with exit code 0
    }

    public static int max(int...ints){
        if(ints.length==0)
            return Integer.MIN_VALUE;

        int max = ints[0];
        for (int anInt : ints) {
            if(anInt>max){
                max = anInt;
            }
        }

        return max;
    }
}
