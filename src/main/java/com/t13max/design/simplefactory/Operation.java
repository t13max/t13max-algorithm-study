package com.t13max.design.simplefactory;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:03
 */
public abstract class Operation {

    /*private double numberA;

    private double numberB;

    public Operation(double numberA, double numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public double getNumberA() {
        return numberA;
    }

    public double getNumberB() {
        return numberB;
    }*/

    public abstract double getResult(final double a,final double b);
}
