package 函数式接口;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * 数组为 "a,b"
 * 需要打印为 No：a。Name：b
 */
public class 格式化打印信息 {
    public static void main(String[] args) {
        String[] arr = {"123,a","321,b","852,c"};
        Arrays.stream(arr).forEach((s)->
            print(s,
                    str-> System.out.print("No："+str.split(",")[0]),
                    str-> System.out.println("。Name:"+str.split(",")[1]))
        );
    }

    public static void print(String s, Consumer<String> c1,Consumer<String> c2){
        c1.andThen(c2).accept(s);
    }
}
