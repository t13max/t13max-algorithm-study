package com.t13max.design.strategy;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:30
 */
public class CashReturn extends CashSuper {

    private double moneyCondition = 0;

    private double moneyReturn = 0;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyReturn = moneyReturn;
        this.moneyCondition = moneyCondition;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if (money > moneyCondition) {
            result = result - (int)(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
