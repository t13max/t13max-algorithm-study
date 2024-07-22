package com.t13max.design.command;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 8:13
 */
public class Main {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command=new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.executeCommand();
    }
}
