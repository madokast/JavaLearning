package 函数式编程;

public class CCTTest {
    public static void main(String[] args) {
        final CCT cct = cctBuilder(CCT::new, 10);
        System.out.println(cct);
    }

    public static CCT cctBuilder(CCTFactory c,int n){
        return c.build(n);
    }
}
