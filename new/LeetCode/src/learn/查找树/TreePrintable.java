package learn.查找树;


/**
 * 打印四层树
 */

public interface TreePrintable<T> {
    // i starts from 1
    // the list of tree like
    //              1
    //           2      3
    //         4   5  6   7
    String get(int i);

    default String get0(int i){
        final String s = get(i);
        if(s==null||s.length()==0)
            return "nu";
        else {
            if(s.length()==1)
                return " "+s;
            else
                return ""+s.charAt(0)+s.charAt(1);
        }
    }

    //第一层=1
    int getFloorNumber();

    default void print(){
        final int floorNumber = getFloorNumber();
        if(floorNumber<=0){
            System.out.println("[]");
            return;
        }

        //1st
        System.out.print("                     ");
        System.out.println(get0(1));

        if(floorNumber>=2){
            System.out.print("         ");
            System.out.print(get0(2));
            System.out.print("                      ");
            System.out.println(get0(3));
        }
        if(floorNumber>=3){
            System.out.print("   ");
            System.out.print(get0(4));
            System.out.print("          ");
            System.out.print(get0(5));
            System.out.print("          ");
            System.out.print(get0(6));
            System.out.print("          ");
            System.out.println(get0(7));
        }

        if(floorNumber>=4){
            for (int i = 8 ; i <= 15; i++) {
                System.out.print(get0(i));
                System.out.print("    ");
            }
            System.out.println();
        }
    }
}

/*
                     AA
         AA                      AA
   AA          AA          AA          AA
AA    AA    AA    AA    AA    AA    AA    AA
 */