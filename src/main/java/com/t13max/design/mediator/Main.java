package com.t13max.design.mediator;

/**
 * 中介对象封装一系列的对象交互
 * 使对象不需要显示的互相引用
 * 一个联合国 认识大家
 * 多对多 减少耦合
 * 控制集中化 交互复杂性变为中介者的复杂性
 *
 * @Author 呆呆
 * @Datetime 2022/4/21 7:43
 */
public class Main {

    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();
        ConcreteColleague1 concreteColleague1 = new ConcreteColleague1(concreteMediator);
        ConcreteColleague2 concreteColleague2 = new ConcreteColleague2(concreteMediator);
        concreteMediator.setColleague1(concreteColleague1);
        concreteMediator.setColleague2(concreteColleague2);

        concreteColleague1.send("给你个大嘴巴子");

        concreteColleague2.send("好的哥");
    }
}
