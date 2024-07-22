package com.t13max.design.visitor;

/**
 * 把处理逻辑从数据结构分离出来 稳定的数据结构 与变化的算法
 *
 * @Author 呆呆
 * @Datetime 2022/4/22 7:23
 */
public class Main {

    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new Man());
        objectStructure.add(new Woman());

        Action success = new Success();
        objectStructure.display(success);

        Action failing = new Failing();
        objectStructure.display(failing);
    }
}
