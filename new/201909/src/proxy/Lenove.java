package proxy;


/**
 * 真实类
 */

public class Lenove implements SaleComputer {
    @Override
    public String sale(double money) {
        return "在Lenove直接买电脑花了"+ money;
    }

    @Override
    public void show() {
        System.out.println("Lenove展示电脑");
    }
}
