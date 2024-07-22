package com.t13max.design.state;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:31
 */
public class ForenoonState extends WorkState {
    @Override
    public void work(Work work) {
        if (work.getHour() < 12) {
            System.out.println("上午12点以前 精神百倍");
        } else {
            work.setWorkState(new NoonState());
            work.doWork();
        }
    }
}
