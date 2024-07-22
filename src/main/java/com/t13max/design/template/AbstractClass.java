package com.t13max.design.template;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 15:41
 */
public abstract class AbstractClass {

    public abstract void one();

    public abstract void two();

    public void templateMethod() {
        one();
        two();
        System.out.println("template");
    }

}
