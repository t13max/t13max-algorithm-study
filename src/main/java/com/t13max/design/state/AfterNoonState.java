package com.t13max.design.state;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:32
 */
public class AfterNoonState extends WorkState {
    @Override
    public void work(Work work) {
        if (work.getHour() < 17) {
            System.out.println("下午加油哇");
        } else {
            work.setWorkState(new EveningState());
            work.doWork();
        }
    }
}
