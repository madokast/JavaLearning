package MySQL.school;

import com.sun.source.tree.CompilationUnitTree;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Sid int auto_increment,
 * Sname varchar(10) not null,
 * Ssex varchar(3) default 'M',
 * Sage int ,
 * Sdept int,
 * constraint ckSex check(Ssex in ('M','F')),
 * constraint ckAge check(Sage>=15 and Sage<=45),
 */

public class Student {
    private String name;
    private boolean sex;
    private int age;
    private int dept;

    public Student(String name, boolean sex, int age, int dept) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
    }

    public Student(String name, String sex, int age, int dept) {
        this.name = name;
        this.sex = sex.equals("M");
        this.age = age;
        this.dept = dept;
    }


    public static Student getOne() {
        final Random random = new Random();
        return new Student(RandomAZ.randomName(), random.nextBoolean(), random.nextInt(31) + 15, Dept.random());
    }

    public static String sqlInsert(Student student) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into student(Sname,Ssex,Sage,Sdept) values( ");
        stringBuilder.append("'" + student.name + "',");
        stringBuilder.append("'" + (student.sex ? "M" : "F") + "',");
        stringBuilder.append(student.age + ",");
        stringBuilder.append(student.dept + "");
        stringBuilder.append(")");

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }

    public static void main(String[] args) {
        Stream.generate(() -> sqlInsert(getOne())).limit(15).forEach(System.out::println);
    }
}
