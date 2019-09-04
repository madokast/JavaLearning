package ichiwanTest;

import java.util.Map;

public class Tools {
    public static void printMapStrStrs(Map<String, String[]> map){
        System.out.println("------printMapStrStrs------");
        map.keySet().forEach(k->{
            final String[] strings = map.get(k);
            for (int i = 0; i < strings.length; i++) {
                System.out.println(k+"->"+strings[i]);
            }
        });
        System.out.println("------printMapStrStrs------");
    }
}
