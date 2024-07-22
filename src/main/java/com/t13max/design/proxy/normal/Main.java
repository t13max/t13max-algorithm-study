package com.t13max.design.proxy.normal;

/**
 * 对其他对象提供一种代理以控制对这个对象的访问
 *
 * @Author 呆呆
 * @Datetime 2022/4/9 15:11
 */
public class Main {

    public static void main(String[] args) {
        Girl girl = new Girl("喵喵");
        Proxy proxy = new Proxy(girl);
        proxy.giveChocolate();
        proxy.giveDolls();
        proxy.giveFlowers();
    }
}
