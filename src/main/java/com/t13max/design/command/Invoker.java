package com.t13max.design.command;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 8:12
 */
public class Invoker {

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
