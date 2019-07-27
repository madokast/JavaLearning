package MySQL.school;

import com.sun.nio.file.ExtendedWatchEventModifier;

import java.util.Random;
import java.util.stream.Stream;

public class RandomAZ {
    public static char randomaz(){
        return (char)(new Random().nextInt('z'-'a')+'a');
    }

    public static char randomAZ(){
        return (char)(new Random().nextInt('Z'-'A')+'A');
    }

    public static String randomaz(int num){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(randomaz());
        }

        return sb.toString();
    }

    public static String randomName(){
        int f = new Random().nextInt(3)+1;
        int l = new Random().nextInt(3)+1;
        StringBuilder sb = new StringBuilder();

        sb.append(randomAZ());
        sb.append(randomaz(f));
        sb.append(" ");
        sb.append(randomAZ());
        sb.append(randomaz(l));

        return sb.toString();
    }

    public static void main(String[] args) {
        Stream.generate(RandomAZ::randomName).limit(10).forEach(System.out::println);
    }
}
