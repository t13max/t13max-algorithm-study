package com.t13max.design.state;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:29
 */
public class Work {

    private WorkState workState;//上下文

    private boolean finish;

    private double hour;

    public Work() {
        this.workState = new ForenoonState();
    }

    public void doWork(){
        workState.work(this);
    }

    public WorkState getWorkState() {
        return workState;
    }

    public void setWorkState(WorkState workState) {
        this.workState = workState;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }
}
