package linuxTool.tool;

public class StringTool {
    private StringTool(){}

    public static int safeString2int(int defaultValue, String numberString){
        try{
            return Integer.parseInt(numberString);
        }catch (Exception e){
            return defaultValue;
        }
    }

    public static boolean isCloseWithDoubleQuotation(String s){
        return s.startsWith("\"")&&s.endsWith("\"");
    }

    public static String removeDoubleQuotation(String s){
        if(isCloseWithDoubleQuotation(s)){
            return s.substring(1,s.length()-1);
        }else {
            return s;
        }
    }
}
