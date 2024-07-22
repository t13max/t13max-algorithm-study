package com.t13max.design.template;

/**
 * 把不变的行为搬到父类 去除子类重复的代码
 *
 * @Author 呆呆
 * @Datetime 2022/4/9 15:43
 */
public class Main {

    public static void main(String[] args) {
        AbstractClass a=new ConcreteClassA();
        AbstractClass b=new ConcreteClassB();
        a.templateMethod();
        b.templateMethod();
    }
}
