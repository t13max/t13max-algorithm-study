package com.t13max.design.state;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:32
 */
public class NoonState extends WorkState {
    @Override
    public void work(Work work) {
        if (work.getHour() < 13) {
            System.out.println("饿饿 饭饭");
        } else {
            work.setWorkState(new AfterNoonState());
            work.doWork();
        }
    }
}
