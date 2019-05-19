package Collection;

import java.util.Random;

public class WashCard {
    public static void main(String[] args) {
//        Random random = new Random();
//        for (int i = 0; i < 20; i++) {
//            System.out.print((random.nextInt(8-4)+4)+"\t");//4~8
//        }
        //上述测试 random.nextInt(n-m)+m 输出 [m,n)
        int[] a = make(100);
        toString(a);
        wash(a);
        toString(a);


    }

    public static void toString(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"  ");
            if((i+1)%20==0){
                System.out.println();
            }
        }
        System.out.println("-------------------");
    }

    public static void wash(int[] a){
        int len = a.length;
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            swap(a,i,random.nextInt(len-i)+i);
        }
    }

    public static void swap(int[] a, int p,int q){
        int temp = a[p];
        a[p] = a[q];
        a[q] = temp;
    }

    public static int[] make(int num){
        int[] a = new int[num];
        for (int i = 0; i < a.length; i++) {
            a[i] = i+1;
        }

        return a;
    }
}

//D:\app\jdk-12.0.1\bin\java.exe "-javaagent:D:\app\IntelliJ IDEA Community Edition 2019.1.1\lib\idea_rt.jar=50253:D:\app\IntelliJ IDEA Community Edition 2019.1.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Documents\GitHub\JavaLearning\new\out\production\201905 Collection.WashCard
//1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20
//21  22  23  24  25  26  27  28  29  30  31  32  33  34  35  36  37  38  39  40
//41  42  43  44  45  46  47  48  49  50  51  52  53  54  55  56  57  58  59  60
//61  62  63  64  65  66  67  68  69  70  71  72  73  74  75  76  77  78  79  80
//81  82  83  84  85  86  87  88  89  90  91  92  93  94  95  96  97  98  99  100
//-------------------
//93  36  48  78  63  89  50  10  94  53  46  68  61  98  25  14  56  97  6  66
//33  95  37  45  72  30  26  39  59  65  64  11  81  16  15  70  49  20  57  99
//88  44  31  13  4  19  21  87  82  77  24  76  84  32  91  75  8  23  3  71
//83  52  41  42  18  86  54  34  1  5  79  90  58  38  51  2  7  80  92  22
//67  74  60  9  47  69  100  62  12  27  73  35  40  28  29  43  55  96  17  85
//-------------------
//
//Process finished with exit code 0