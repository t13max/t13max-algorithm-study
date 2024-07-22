package com.t13max.design.interpreter;

/**
 * @Author 呆呆
 * @Datetime 2022/4/22 7:07
 */
public class NonTerminalExpression extends AbstractExpression {

    @Override
    public void interpret(Context context) {
        System.out.println("非终端解释器");
    }
}
