package com.t13max.design.builder;

/**
 * @Author 呆呆
 * @Datetime 2022/4/18 7:45
 */
public class Director {

    public void construct(Builder builder){

        builder.buildPartA();
        builder.buildPartB();
    }
}
