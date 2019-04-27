package IDEAJAVALEARN.nineInherit;

public class Cat extends Animal{
    public Cat()
    {
        super();
    }

    @Override
    public void eat(){
        System.out.println("吃鱼");
    }
}
