package com.t13max.design.observer;

/**
 * @Author 呆呆
 * @Datetime 2022/4/18 8:03
 */
public class ConcreteSubject extends Subject {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
