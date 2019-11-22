package tool.timer;

/**
 * Description
 * 阿拉伯数字转汉字
 * <p>
 * Data
 * 2019/11/21 9:41
 *
 * @author zrx
 * @version 1.0
 */

public class NumberConverter {
    private static String[] kanji = new String[]{
            "ト",//0
            "ヒ",//1
            "フ",//2
            "ミ",//3
            "ヨ",//4
            "イ",//5
            "ム",//6
            "ナ",//7
            "ヤ",//8
            "コ"//9
    };

    public static String convert(int number){
        String numberString = String.valueOf(number);
        StringBuilder sb  = new StringBuilder();

        for (int i = 0; i < numberString.length(); i++) {
            sb.append(kanji[Integer.valueOf(String.valueOf(numberString.charAt(i)))]);
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            System.out.println(convert(i));
        }
    }
}
