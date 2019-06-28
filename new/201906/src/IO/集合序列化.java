package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.LongUnaryOperator;

public class 集合序列化 {
    public static void main(String[] args) throws Exception{
//        List<Person> list = new ArrayList<>();
//        list.add(new Person("asd",2314));
//        list.add(new Person("fvs",6));
//        list.add(new Person("vsd",214));
//        list.add(new Person("grwsg",14));
//        System.out.println(list);

//        s(list);

        Object uns = uns();
        System.out.println("uns = " + uns);
        //�� sr java.util.ArrayListx����a� I sizexp   w   sr 	IO.Person#�}x�1б I ageL namet Ljava/lang/String;xp
        //t asdsq ~    t fvssq ~    �t vsdsq ~    t grwsgx
    }

    private static void s(Object o) throws Exception{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(new File("./text.txt"))
        );
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }

    private static Object uns()throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(new File("./text.txt"))
        );

        return objectInputStream.readObject();
    }
}
