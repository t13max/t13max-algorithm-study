package com.t13max.design.state;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:21
 */
public class Context {

    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        this.state.handle(this);
    }
}
