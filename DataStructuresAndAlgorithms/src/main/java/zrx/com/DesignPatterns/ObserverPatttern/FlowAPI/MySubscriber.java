package zrx.com.DesignPatterns.ObserverPatttern.FlowAPI;

import zrx.com.MultiThread.MyTools;

import java.util.concurrent.Flow;
import java.util.stream.IntStream;

/**
 * Description
 * 订阅者
 * 从订阅者开始，MagazineSubscriber
 * 实现了Flow.Subscriber<Integer>，
 * 订阅者将收到一个数字，但请假设这
 * 是一份杂志正如上面的使用场景提到的。
 * <p>
 * Data
 * 2019/11/26 13:50
 *
 * @author zrx
 * @version 1.0
 */

public class MySubscriber implements Flow.Subscriber<Integer> {

    private final long sleepTime;
    private final String subscriberName;
    private Flow.Subscription subscription;
    private int nextNumberExpected;
    private int totalRead;


    public MySubscriber(final long sleepTime,final String subscriberName) {
        super();
        this.sleepTime = sleepTime;
        this.subscriberName = subscriberName;
        this.nextNumberExpected = 1;
        this.totalRead = 0;
    }


    /**
     * Publisher在被指定一个新的Subscriber时调用此方法。
     * 一般来说你需要在subscriber内部保存这个subscrition实例，
     * 因为后面会需要通过她向publisher发送信号来完成：
     * 请求更多数据，或者取消订阅。 一般在这里我们会直接请求
     * 第一个数据，正如代码中所示。
     *
     * 作者：资良_Leo
     * 链接：https://www.jianshu.com/p/ce207be13078
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param subscription 1.是订阅者和发布者建立了关系的凭证 2.订阅者凭借这个和发布者联系
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    /**
     * 每当新的数据产生，这个方法会被调用。
     * 在我们的示例中，我们用到了最经典的
     * 使用方式：处理这个数据的同时再请求
     * 下一个数据。然而我们在这中间添加了
     * 一段可配置的sleep时间，这样我们可
     * 以尝试订阅者在不同场景下的表现。剩
     * 下的一段逻辑判断仅仅是记录下丢失的
     * 杂志（当publisher出现丢弃数据的时
     * 候）。
     *
     * 作者：资良_Leo
     * 链接：https://www.jianshu.com/p/ce207be13078
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param item 收到的信息
     */
    @Override
    public void onNext(final Integer item) {
        if(item!=nextNumberExpected){
            IntStream.range(nextNumberExpected,item).forEach(i-> System.out.println(
                    getSubcriberName()+"错过了信息: "+ i
            ));
            //跟上去
            nextNumberExpected = item;
        }

        System.out.println(getSubcriberName()+"拿到了新信息: " + item);
        MyTools.sleepSelf(sleepTime);//处理数据中

        nextNumberExpected++;
        totalRead++;

        System.out.println(getSubcriberName()+"将要获取下一个数字，他应该是: "+ nextNumberExpected);
        subscription.request(1);
    }

    /**
     * 当publisher出现异常时会调用
     * subscriber的这个方法。在我们
     * 的实现中publisher丢弃数据时
     * 会产生异常。
     * @param throwable 来自发布者的异常
     */
    @Override
    public void onError(Throwable throwable) {
        System.err.println(getSubcriberName().trim()+"从发布者处获得了一个错误信息: "+ throwable.getMessage());
    }

    /**
     * 当publisher数据推送完毕时会调用此方法，于是整个订阅过程结束。
     */
    @Override
    public void onComplete() {
        System.out.println(getSubcriberName()+"完成这次订阅，一共获得了:" + totalRead);
    }

    public String getSubcriberName() {
        return subscriberName;
    }
}
