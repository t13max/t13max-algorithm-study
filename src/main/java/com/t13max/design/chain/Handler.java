package com.t13max.design.chain;

/**
 * @Author 呆呆
 * @Datetime 2022/4/21 7:11
 */
public abstract class Handler {

    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int request);
}
