package com.t13max.design.strategy;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:30
 */
public class CashRebate extends CashSuper {

    private double moneyRebate = 1;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * moneyRebate;
    }
}
