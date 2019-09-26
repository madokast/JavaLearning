package Java并发编程的艺术.Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToList {
    public static List to(Object[] objects){
        final ArrayList<Object> objects1 = new ArrayList<>(objects.length);
        Arrays.stream(objects).forEach(e->objects1.add(e));
        return objects1;
    }
}
