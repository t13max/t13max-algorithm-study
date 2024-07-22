package com.t13max.design.observer;

/**
 * 委托 引用方法
 *
 * @Author 呆呆
 * @Datetime 2022/4/18 8:06
 */
public class Main {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.add(new ConcreteObserver("X", concreteSubject));
        concreteSubject.add(new ConcreteObserver("Y", concreteSubject));
        concreteSubject.setState("AAA");
        concreteSubject.notifyObservers();
    }
}
