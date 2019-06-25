import javax.sound.midi.Soundbank;

public class RomanTonteger013 {
    public static void main(String[] args) {
        System.out.println(new RomanTonteger013().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int length = s.length();
        int num = 0;
        int nextNum = 0;
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            num = charToInt(s.charAt(i));
            nextNum = charToInt(s.charAt(i + 1));
            if (num >= nextNum) sum += num;
            else sum -= num;
        }
        return sum + charToInt(s.charAt(length - 1));
    }

    public int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000