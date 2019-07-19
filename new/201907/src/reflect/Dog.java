package reflect;

public class Dog {
    private String name;
    private String color;

    public void say(){
        System.out.println(toString()+"wawawa");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Dog() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
