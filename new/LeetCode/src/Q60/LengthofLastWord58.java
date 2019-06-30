package Q60;

public class LengthofLastWord58 {
    public static void main(String[] args) {
        System.out.println("new Q60.LengthofLastWord58().lengthOfLastWord(\"  a c dd  \") = " + new LengthofLastWord58().lengthOfLastWord("123"));
    }

    public int lengthOfLastWord(String s) {
        if(s.length()==0)
            return 0;

        int i = s.length()-1;
        while(i>0&&s.charAt(i)==' ')
            i--;
        int j = i;
        while (j>0&&s.charAt(j)!=' ')
            j--;

        if(s.charAt(j)!=' ')
            return i-j+1;

        return i-j;
    }
}
