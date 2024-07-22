package com.t13max.design.state;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:32
 */
public class EveningState extends WorkState {
    @Override
    public void work(Work work) {
        if (work.isFinish()) {
            System.out.println("完成啦");
            work.setWorkState(new RestState());
            work.doWork();

        } else {
            if (work.getHour() < 21) {
                System.out.println("加班");
            } else {
                work.setWorkState(new SleepingState());
                work.doWork();
            }
        }
    }
}
