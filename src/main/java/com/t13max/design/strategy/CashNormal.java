package com.t13max.design.strategy;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:30
 */
public class CashNormal extends CashSuper{
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
