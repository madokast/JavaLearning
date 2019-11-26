package zrx.com.DesignPatterns.ObserverPatttern;

/**
 * Description
 * 发布信息
 * <p>
 * Data
 * 2019/11/25 17:52
 *
 * @author zrx
 * @version 1.0
 */

public class WeatherStation extends MyObservable {
    Double temperature;
    Double humidity;

    public WeatherStation(){
        super();
        temperature = 0.0;
        humidity = 0.0;
    }

    public void change(Double temperature, Double humidity){
        this.humidity=humidity;
        this.temperature=temperature;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }
}
