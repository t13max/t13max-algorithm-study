package com.t13max.design.proxy.normal;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 15:09
 */
public class Proxy implements IGiveGift {

    private Pursuit pursuit;

    public Proxy(Girl girl) {
        this.pursuit = new Pursuit(girl);
    }

    @Override
    public void giveDolls() {
        pursuit.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }
}
