package com.t13max.design.simplefactory;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:01
 */
public class OperationFactpry {

    public static Operation createOperation(String operate) {
        Operation result = null;

        switch (operate) {
            case "+":
                result=new OperationAdd();
                break;
            case "-":
                result=new OperationSub();
                break;
            case "*":
                result=new OperationMul();
                break;
            case "/":
                result=new OperationDiv();
                break;
            default:
        }
        return result;
    }
}
