package com.t13max.design.factorymethod;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 15:24
 */
public class AddFactory implements IFactory {

    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
