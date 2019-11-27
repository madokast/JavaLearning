package zrx.com.DesignPatterns.ObserverPatttern.FlowAPI;

import zrx.com.MultiThread.MyTools;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Description
 * 发布者
 * 我们将使用Java9 SubmissionPublisher类来创建publisher。
 * 正如javadoc所述， 当subscribers消费过慢，就像Reactive
 * Streams中的Publisher一样她会阻塞或丢弃数据。在深入理解
 * 之前让我们先看代码。
 *
 * 作者：资良_Leo
 * 链接：https://www.jianshu.com/p/ce207be13078
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * Data
 * 2019/11/26 14:15
 *
 * @author zrx
 * @version 1.0
 */

public class ReactiveFlowApp {
    private static final int TOTAL_NUMBERS = 20;
    private static final int MAX_SECONDS_TO_KEEP_IT_WHEN_NO_SPACE = 200;

    public static void main(String[] args)throws Exception {
        MyTools.printCurrentMethod(true);
        final ReactiveFlowApp app = new ReactiveFlowApp();

        System.err.println("情况一，大家都很快，缓存不是很需要");
        app.deliveryTest(50L,50L,8);
        System.err.println();


        System.err.println("情况二，有一个很慢，但是缓存很大");
        app.deliveryTest(50L,500L,TOTAL_NUMBERS);
        System.err.println();

        System.err.println("情况三，有一个很慢，缓存不是很大");
        app.deliveryTest(50L,500L,2);
        System.err.println();

        //你还可以尝试其他组合，比如设置MAX_SECONDS_TO_WAIT_WHEN_NO_SPACE为
        // 很大的数字，这时offer表象将类似于submit，或者可以尝试将两个消费者
        // 速度同时降低（会出现大量丢弃数据)。
        //
        //作者：资良_Leo
        //链接：https://www.jianshu.com/p/ce207be13078
        //来源：简书
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    }

    void deliveryTest(final long sleepTimeJack,
                      final long sleepTimePete,
                      final int maxStorageInPO) throws Exception{
        //创建SubmissionPublisher并设置一个标准的线程池（每个subscriber拥有一个线程）
        final SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>(
                //背景：ForkJoinPool的优势在于，可以充分利用多cpu，
                // 多核cpu的优势，把一个任务拆分成多个“小任务”，
                // 把多个“小任务”放到多个处理器核心上并行执行；
                // 当多个“小任务”执行完成之后，再将这些执行结果
                // 合并起来即可。这种思想值得学习。
                //是一种特殊的线程池
                //创建了ForkJoinPool实例之后，就可以调用ForkJoinPool的submit
                // (ForkJoinTask<T> task) 或invoke(ForkJoinTask<T> task)方法来执行指定任务了。
                //
                ForkJoinPool.commonPool(),maxStorageInPO
        );

        //创建两个subscribers，通过传递变量设置不同的消费时间和不同的名字，以在log中方便区别
        final MySubscriber jack = new MySubscriber(sleepTimeJack, "quicker");
        final MySubscriber pete = new MySubscriber(sleepTimePete, "                         slower");

        publisher.subscribe(jack);
        publisher.subscribe(pete);

        System.out.println("给每个订阅者20个数，我这边用"+maxStorageInPO+"大小的空间缓存一下，" +
                "每个订阅者有" + MAX_SECONDS_TO_KEEP_IT_WHEN_NO_SPACE +"秒来消费数");

        //用20个数字的的stream数据集作为数据源以扮演“杂志打印机”，我们调用offer，并传递以下变量：
        IntStream.rangeClosed(1,TOTAL_NUMBERS).forEach((number)->{
            System.out.println("发布者发布: " +number);

            //当丢弃数据发生时，offer方法返回一个负数，
            // 否则将返回publisher的最大容量（以供最慢的subscriber消费），同时打印这个数字。
            final int lag = publisher.offer(number//提供给subscribers的数据。

                    ,MAX_SECONDS_TO_KEEP_IT_WHEN_NO_SPACE,
                    TimeUnit.MILLISECONDS,//第二和第三个变量是等待subscribers获取杂志的最大时间。

                    //BiPredicate
                    //控制器以处理数据丢弃的情况。这里我们抛出了一个异常，
                    // 返回false意味着告诉publisher不需要重试。
                    (subscriber,msg)->{
                subscriber.onError(new RuntimeException("你好啊，" +
                        ((MySubscriber)subscriber).getSubcriberName()+",你处理得太慢了，我只好扔了" + msg));
                return false;
                    });

            if(lag<0){
                System.out.println("发行者扔了" + -lag + "个数");
            }else {
                System.out.println("最慢的消费者还剩" + lag + "等待处理");
            }
        });

        //最后我们添加了一个循环等待以防止主进程过早结束。
        // 这里一个是等待publisher清空缓存数据
        // ，另外等待最慢的subscriber收到onComplete回调信号（close()调用之后）
        while (publisher.estimateMaximumLag()>0){
            MyTools.sleepSelf(100);
        }

        publisher.close();

        MyTools.sleepSelf(Math.max(sleepTimeJack,sleepTimePete));
    }
}
