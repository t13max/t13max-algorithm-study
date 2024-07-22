package com.t13max.design.abstractfactory;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:13
 */
public class ConcreteFactory1 extends AbstractFactory{
    @Override
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}
