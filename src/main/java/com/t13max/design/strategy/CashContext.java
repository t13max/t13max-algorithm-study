package com.t13max.design.strategy;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:36
 */
public class CashContext {

    private CashSuper cashSuper = null;

    public CashContext(String type) {

        switch (type) {

            case "normal":
                this.cashSuper = new CashNormal();
                break;
            case "300-100":
                this.cashSuper = new CashReturn(300, 100);
                break;
            case "0.8":
                this.cashSuper = new CashRebate(0.8);
                break;

            default:
        }
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
