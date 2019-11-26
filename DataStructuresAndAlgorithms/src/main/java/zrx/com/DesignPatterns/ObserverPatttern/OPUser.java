package zrx.com.DesignPatterns.ObserverPatttern;

import java.util.Observable;
import java.util.Observer;

/**
 * Description
 * 观察者设计模式
 * <p>
 * Data
 * 2019/11/25 17:14
 *
 * @author zrx
 * @version 1.0
 */

public class OPUser {
    //都过时了
//    Observable observable;
//    Observer observer;

    public static void use(){
        WeatherStation weatherStation = new WeatherStation();

        GeneralDisplay display1 = new GeneralDisplay(weatherStation);
        GeneralDisplay display2 = new GeneralDisplay(weatherStation);
        GeneralDisplay display3 = new GeneralDisplay(weatherStation);

        weatherStation.change(10.,20.);
        System.out.println("--------------WeatherStation发布消息--------------");
        weatherStation.notifyObservers();
        weatherStation.change(15.,25.);
        System.out.println("--------------WeatherStation发布消息--------------");
        weatherStation.notifyObservers();
        weatherStation.change(20.,30.);
        System.out.println("--------------WeatherStation发布消息--------------");
        weatherStation.notifyObservers();
    }
}
