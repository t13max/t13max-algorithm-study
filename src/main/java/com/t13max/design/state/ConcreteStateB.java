package com.t13max.design.state;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:22
 */
public class ConcreteStateB extends State{
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}
