package synchronizedLearn.safeSynchronizedMethod;

public class Seller {
    private static Seller ourInstance = new Seller();

    public static Seller getInstance() {
        return ourInstance;
    }

    private Seller() {
    }

//    public void sell
}
