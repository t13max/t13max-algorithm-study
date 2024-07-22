package com.t13max.design.factorymethod;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:04
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult(double a, double b) {
        return a+b;
    }

    /*public OperationAdd(double numberA, double numberB) {
        super(numberA, numberB);
    }*/



}
