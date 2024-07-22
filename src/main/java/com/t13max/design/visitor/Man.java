package com.t13max.design.visitor;

/**
 * @Author 呆呆
 * @Datetime 2022/4/22 7:17
 */
public class Man extends Person{

    @Override
    public void accept(Action action) {
        action.getManConclusion(this);
    }
}
