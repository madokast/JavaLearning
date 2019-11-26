package zrx.com.DesignPatterns.ObserverPatttern;

import java.util.HashSet;
import java.util.Set;

/**
 * Description
 * 可观察的人，通知观察者
 * <p>
 * Data
 * 2019/11/25 17:48
 *
 * @author zrx
 * @version 1.0
 */

public abstract class MyObservable {
    private Set<MyObserver> set;

    public MyObservable(){
        set = new HashSet<>();
    }

    public void addObserver(MyObserver t){
        set.add(t);
    }

    public void deleteObserver(MyObserver t){
        set.remove(t);
    }

    public void notifyObservers(){
        set.forEach(MyObserver::update);
    }



}
