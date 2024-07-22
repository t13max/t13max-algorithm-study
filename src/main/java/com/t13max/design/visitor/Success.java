package com.t13max.design.visitor;

/**
 * @Author 呆呆
 * @Datetime 2022/4/22 7:18
 */
public class Success extends Action {

    @Override
    public void getManConclusion(Man concreteElementA) {
        System.out.println(String.format("%s%s时,背后多半有一个伟大的女人", concreteElementA.getClass(), this.getClass()));
    }

    @Override
    public void getWomanConclusion(Woman concreteElementB) {
        System.out.println(String.format("%s%s时,背后多半有一个不成功的男人", concreteElementB.getClass(), this.getClass()));
    }
}
