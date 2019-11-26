package zrx.com.DesignPatterns.ObserverPatttern;

/**
 * Description
 * 观察者
 * <p>
 * Data
 * 2019/11/25 17:54
 *
 * @author zrx
 * @version 1.0
 */

public class GeneralDisplay implements MyObserver {
    private WeatherStation weatherStation;

    public GeneralDisplay(WeatherStation weatherStation){
        super();
        this.weatherStation = weatherStation;
        weatherStation.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("GeneralDisplay收到了更新报告");
        System.out.println("weatherStation.getTemperature() = " + weatherStation.getTemperature());
    }


}
