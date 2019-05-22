package exception;


public class FinallyTest {
    public static void main(String[] args) {
//        int a = 1;
//        int b = 0;
//        try{
//            System.out.println(a/b);
//            System.out.println("release000");
//        }catch (Exception e){}
//        finally {
//
//            System.out.println("release001");
//        }
        System.out.println("getA() = " + getA());
    }

    private static int getA() {
        int a = 10;
        try{ return ++a; }
        catch (Exception e){}
        finally { return ++a; }





//        int a = 10;
//        try{
//            System.out.println("before try return a=" + a);
//            return ++a;
//        }catch (Exception e){}
//        finally {
//            System.out.println("before finally return a=" + a);
//            return ++a;
//            //finally codes are always executed
//        }

        //return 0;
    }
}
