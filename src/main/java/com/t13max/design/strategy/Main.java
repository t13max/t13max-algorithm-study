package com.t13max.design.strategy;

/**
 * 让客户端只知道Context一个类 工厂在Context里维护
 *
 * 策略模式定义一系列算法 完成相同工作 只是实现不同
 *
 * @Author 呆呆
 * @Datetime 2022/4/9 14:39
 */
public class Main {

    public static void main(String[] args) {
        CashContext cashContext1 = new CashContext("300-100");
        CashContext cashContext2 = new CashContext("0.8");
        System.out.println(cashContext1.getResult(301));
        System.out.println(cashContext1.getResult(601));
        System.out.println(cashContext2.getResult(100));
    }
}
