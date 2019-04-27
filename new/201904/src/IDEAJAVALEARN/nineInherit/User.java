package IDEAJAVALEARN.nineInherit;

public class User {
    private int money;
    private int ID;

    public User(int money, int ID) {
        this.money = money;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "money=" + money +
                ", ID=" + ID +
                '}';
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMoney() {
        return money;
    }

    public int getID() {
        return ID;
    }
}
