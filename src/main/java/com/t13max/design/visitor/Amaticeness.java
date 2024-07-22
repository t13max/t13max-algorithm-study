package com.t13max.design.visitor;

/**
 * @Author 呆呆
 * @Datetime 2022/4/22 7:18
 */
public class Amaticeness extends Action {

    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(String.format("%s%s时,xxxxx", concreteElementA.getClass(), this.getClass()));
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(String.format("%s%s时,xxxxx", concreteElementB.getClass(), this.getClass()));
    }
}
