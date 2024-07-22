package com.t13max.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 呆呆
 * @Datetime 2022/4/18 8:01
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        if (observer == null) {
            return;
        }
        this.observers.add(observer);
    }

    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
}
