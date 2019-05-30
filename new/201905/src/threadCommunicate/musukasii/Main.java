package threadCommunicate.musukasii;

public class Main {
    public static void main(String[] args) {
        Productor productor = new Productor();
        Shopper shopper = new Shopper();

        Thread p1 = new Thread(productor);
        Thread p2 = new Thread(productor);
        Thread p3 = new Thread(productor);

        Thread s1 = new Thread(shopper);
        Thread s2 = new Thread(shopper);
        Thread s3 = new Thread(shopper);

        p1.setName("pro1");
        p2.setName("pro2");
        p3.setName("pro3");

        s1.setName("sho1");
        s2.setName("sho2");
        s3.setName("sho3");


        p1.start();
        p2.start();
        p3.start();

        s1.start();
        s2.start();
        s3.start();
    }
}
