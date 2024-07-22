package com.t13max.design.command;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 8:11
 */
public class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        getReceiver().action();
    }
}
