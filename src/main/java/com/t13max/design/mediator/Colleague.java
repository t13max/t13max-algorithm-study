package com.t13max.design.mediator;

/**
 * @Author 呆呆
 * @Datetime 2022/4/21 7:33
 */
public abstract class Colleague {

    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String message);

    //public abstract void notifyMessage(String message);
    public void notifyMessage(String message) {
        System.out.println(this.getClass() + "得到消息" + message);
    }
}
