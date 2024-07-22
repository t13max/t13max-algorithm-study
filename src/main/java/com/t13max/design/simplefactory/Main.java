package com.t13max.design.simplefactory;

/**
 * 逻辑与业务分开 松耦合
 * @Author 呆呆
 * @Datetime 2022/4/9 14:16
 */
public class Main {

    public static void main(String[] args) {
        Operation operationAdd = OperationFactpry.createOperation("+");
        System.out.println(operationAdd.getResult(1, 9));
        Operation operationSub = OperationFactpry.createOperation("-");
        System.out.println(operationSub.getResult(1, 9));
        Operation operationDiv = OperationFactpry.createOperation("/");
        System.out.println(operationDiv.getResult(1, 9));
    }
}
