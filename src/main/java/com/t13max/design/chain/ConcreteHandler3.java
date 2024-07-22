package com.t13max.design.chain;

/**
 * @Author 呆呆
 * @Datetime 2022/4/21 7:12
 */
public class ConcreteHandler3 extends Handler {

    @Override
    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.println(this.getClass() + " handle " + request);
        } else if (getSuccessor() != null) {
            getSuccessor().handleRequest(request);
        }
    }
}
