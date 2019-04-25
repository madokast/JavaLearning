package madoka;

public class LabelBC {
    public static void main(String[] args) {
        outer: for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(i==2)
                    continue outer;
                    //break outer;//结束外层循环，内层当然也结束了

                System.out.println(""+i+j);
            }
        }
    }


}
