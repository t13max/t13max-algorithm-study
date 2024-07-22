package com.t13max.design.abstractfactory;

/**
 * 提供一个创建一系列相关或相互依赖的对象的接口 无需指定具体类
 * 简单工厂 简化抽象工厂
 * 反射
 *
 * @Author 呆呆
 * @Datetime 2022/4/19 7:15
 */
public class Main {

    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory2();
        AbstractProductA productA = factory.createProductA();
        productA.show();
        AbstractProductB productB = factory.createProductB();
        productB.show();
    }
}
