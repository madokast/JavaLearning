package IDEAJAVALEARN.ElevenFinal;

public class LocalClass {
    public void fun(){
        class A{int a=10;}

        System.out.println("(new A().a) = " + (new A().a));
    }

    public void fun2(){
        class A{int a=10;}

        System.out.println("(new A().a) = " + (new A().a));
    }

    public Object fun3(){
        class A{
            int a  = 123;
            @Override
            public String toString(){
                return this.hashCode()+"@"+this.a;
            }
        }

        return new A();
    }
}
