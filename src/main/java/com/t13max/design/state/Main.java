package com.t13max.design.state;

/**
 * 一个对象的内部状态改变时允许改变其行为
 * 消除庞大的 条件分支语句
 * 把各种状态的逻辑分不到不同子类里 减少互相依赖
 *
 * @Author 呆呆
 * @Datetime 2022/4/19 7:24
 */
public class Main {

    public static void main(String[] args) {
        Work work = new Work();
        work.setFinish(true);
        work.setHour(20);
        work.doWork();
    }
}
