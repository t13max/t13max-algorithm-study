package com.t13max.design.interpreter;

/**
 * @Author 呆呆
 * @Datetime 2022/4/22 7:07
 */
public class TerminalExpression extends AbstractExpression{

    @Override
    public void interpret(Context context) {
        System.out.println("终端解释器");
    }
}
