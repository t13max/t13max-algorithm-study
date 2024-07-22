package com.t13max.design.command;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 8:08
 */
public abstract class Command {

    private Receiver receiver;

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    abstract public void execute();
}
