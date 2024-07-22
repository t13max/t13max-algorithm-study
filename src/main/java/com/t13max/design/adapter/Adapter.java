package com.t13max.design.adapter;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:44
 */
public class Adapter extends Target {

    private Adaptee adaptee;

    @Override
    public void request() {
        adaptee.specialRequest();
    }
}
