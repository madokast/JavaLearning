package IDEAJAVALEARN.nineInherit;

public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.normal_mathod();
        Teacher.static_mathod();
        
        Employee employee = new Employee();

        System.out.println("employee.num = " + employee.num);
        System.out.println("teacher.num = " + teacher.num);

        System.out.println("=====================");

        employee.eprint();//100
        teacher.tprint();//1000
        teacher.eprint();//100

        System.out.println("------------------------");

        teacher.tprint();
        //T.num = 1000
        //super.num = 100
    }
}
