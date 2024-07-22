package com.t13max.design.visitor;

/**
 * @Author 呆呆
 * @Datetime 2022/4/22 7:18
 */
public class Woman extends Person {

    @Override
    public void accept(Action action) {
        action.getWomanConclusion(this);
    }
}
