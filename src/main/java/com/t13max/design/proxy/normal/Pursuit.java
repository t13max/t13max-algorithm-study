package com.t13max.design.proxy.normal;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 15:07
 */
public class Pursuit implements IGiveGift {

    private Girl girl;

    public Pursuit(Girl girl) {
        this.girl = girl;
    }

    @Override
    public void giveDolls() {
        System.out.println(this.girl.getName() + ",送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(this.girl.getName() + ",送你花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(this.girl.getName() + ",送你巧克力");
    }
}
