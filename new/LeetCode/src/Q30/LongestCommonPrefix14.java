package Q30;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix14().longestCommonPrefix(new String[]{"a", "ab"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].length() <= i || strs[j + 1].length() <= i || strs[j].charAt(i) != strs[j + 1].charAt(i))
                    return sb.toString();
            }
            sb.append(strs[0].charAt(i));
            i++;
        }
    }
}