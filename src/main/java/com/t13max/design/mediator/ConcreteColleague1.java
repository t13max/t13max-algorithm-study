package com.t13max.design.mediator;

/**
 * @Author 呆呆
 * @Datetime 2022/4/21 7:38
 */
public class ConcreteColleague1 extends Colleague {

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        getMediator().send(message, this);
    }

}
