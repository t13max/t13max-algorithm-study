package com.t13max.design.visitor;

/**
 * @Author 呆呆
 * @Datetime 2022/4/22 7:15
 */
public abstract class Action {

    public abstract void getManConclusion(Man concreteElementA);

    public abstract void getWomanConclusion(Woman concreteElementB);
}
