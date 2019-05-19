package test;

public class NMON {
    public static void main(String[] args) {
        System.out.println("nmon(1,6) = " + nmon(1,6));
        System.out.println("nmon(2,3) = " + nmon(2,3));
        //nmon(1,6) = 7
        //nmon(2,3) = 10
        System.out.println("nmon(1,0) = " + nmon(1, 0));
        //nmon(1,0) = 1
    }

    private static int nmon(int NO,int NV) {
        int NMON = 1;
        for(int i = 1;i<=NO;i++){
            NMON = NMON*(NV+i)/i ;
        }
        return NMON;
    }
}
