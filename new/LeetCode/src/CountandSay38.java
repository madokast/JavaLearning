public class CountandSay38 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new CountandSay38().countAndSay(i));
        }
    }

    public String countAndSay(int n) {
        String s = "1";
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            sb.delete(0,sb.length());
            int j = 0;
            int count;
            while (j<s.length()){
                char ele = s.charAt(j);
                count=1;
                while (true){
                    j++;
                    if(j<s.length()&&ele==s.charAt(j)){
                        count++;
                    }else {
                        sb.append(count).append(ele);
                        break;
                    }
                }
            }
            s=sb.toString();
        }
        return sb.toString();
    }
}
