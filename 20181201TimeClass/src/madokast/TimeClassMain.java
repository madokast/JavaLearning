package madokast;

import java.time.*;

public class TimeClassMain {
    public static void main(String[] args) {
        //clock
        Clock clock= Clock.systemUTC();//格林威治时间 (GMT)
        System.out.println("now is "+clock.instant());//now is 2018-12-01T13:21:08.116070700Z
        System.out.println("clock.millis() "+clock.millis());
        System.out.println("System.currentTimeMillis "+ System.currentTimeMillis());

        //duration
        Duration d=Duration.ofSeconds(6000);
        Clock clock2=Clock.offset(clock,d);
        System.out.println(clock2.instant());

        //instant
        Instant instant=Instant.now();
        System.out.println(instant);//2018-12-01T13:21:08.197078400Z
        
        //local date
        LocalDate ld = LocalDate.now();
        System.out.println("ld = " + ld);//ld = 2018-12-01
        System.out.println(LocalDate.ofYearDay(1999,200));//1999-07-19
        
        //local time
        LocalTime lt= LocalTime.now();
        System.out.println("lt = " + lt);//lt = 21:25:26.763363300
        


    }
}
