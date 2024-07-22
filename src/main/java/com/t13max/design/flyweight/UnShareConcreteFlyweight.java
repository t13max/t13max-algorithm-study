package com.t13max.design.flyweight;

/**
 * @Author 呆呆
 * @Datetime 2022/4/21 8:01
 */
public class UnShareConcreteFlyweight extends Flyweight {

    @Override
    public void operation(int state) {
        System.out.println(this.getClass() + " " + state);
    }
}
