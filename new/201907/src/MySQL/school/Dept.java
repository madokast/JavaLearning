package MySQL.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * CREATE TABLE if not exists  Dept(
 * 	Did int auto_increment primary key ,
 * 	Dname varchar(10) unique not null default '计算机系'
 * );
 */

public class Dept {
    private Dept(){}
    private static final List<String> Dnames = new ArrayList<>();
    public static final int NUM;

    static {
        Dnames.add("计算机系");
        Dnames.add("物理系");
        Dnames.add("电气系");
        Dnames.add("机电系");
        Dnames.add("英语系");
        NUM=Dnames.size();
    }

    public static String initial(){
        final StringBuilder sb = new StringBuilder();
        sb.append("insert into Dept(Dname) values");
        Dnames.stream().forEach(
                s->sb.append("('"+s+"'),")
        );

        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public static int random(){
        return new Random().nextInt(NUM)+1;
    }

    public static void main(String[] args) {
//        System.out.println("initial() = " + initial());

//        Stream.generate(Dept::random).limit(10).forEach(s-> System.out.println("s = " + s));
    }
}
