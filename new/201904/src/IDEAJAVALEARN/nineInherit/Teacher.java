package IDEAJAVALEARN.nineInherit;

public class Teacher extends Employee {
    int num = 1000;

    @Override
    public void print(String a) {
        System.out.println("a = " + a);
    }

    public void tprint()
    {
        System.out.println("T.num = " + num);
        System.out.println("super.num = " + super.num);
    }

}
