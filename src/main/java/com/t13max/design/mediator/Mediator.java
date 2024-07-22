package com.t13max.design.mediator;

/**
 * @Author 呆呆
 * @Datetime 2022/4/21 7:32
 */
public abstract class Mediator {

    public abstract void send(String message,Colleague colleague);
}
