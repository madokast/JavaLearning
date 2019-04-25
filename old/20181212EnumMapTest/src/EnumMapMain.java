import javax.lang.model.SourceVersion;
import java.util.EnumMap;

public class EnumMapMain {
    public static void main(String[] args) {
        EnumMap sm = new EnumMap(Season.class);
        System.out.println("sm = " + sm);
        //sm = {}
        
        sm.put(Season.FALL,"qiu");
        sm.put(Season.WINTER,"dong");

        System.out.println("sm = " + sm);
        //sm = {FALL=qiu, WINTER=dong}
        
    }
    
}

enum Season{
    SPRING,SUMMER,FALL,WINTER
}
