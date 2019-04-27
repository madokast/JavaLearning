package IDEAJAVALEARN.nineInherit;

public class TestAb {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.eat();

        Animal b = new Animal() {
            @Override
            public void eat() {
                System.out.println("????");
            }
        };

        b.eat();
    }
}
