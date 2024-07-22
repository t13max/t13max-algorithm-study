package com.t13max.design.state;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:32
 */
public class RestState extends WorkState {
    @Override
    public void work(Work work) {

        System.out.println("回家睡觉觉");

    }
}
