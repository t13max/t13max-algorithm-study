package com.t13max.design.observer;

/**
 * @Author 呆呆
 * @Datetime 2022/4/18 8:04
 */
public class ConcreteObserver extends Observer {

    private String name;

    private String state;

    private ConcreteSubject subject;

    public ConcreteObserver(String name, ConcreteSubject subject) {
        this.name = name;
        this.subject = subject;
    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        state = subject.getState();
        System.out.println(name + " " + state);
    }
}
