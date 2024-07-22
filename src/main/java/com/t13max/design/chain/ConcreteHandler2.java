package com.t13max.design.chain;

/**
 * @Author 呆呆
 * @Datetime 2022/4/21 7:12
 */
public class ConcreteHandler2 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println(this.getClass() + " handle " + request);
        } else if (getSuccessor() != null) {
            getSuccessor().handleRequest(request);
        }
    }
}
