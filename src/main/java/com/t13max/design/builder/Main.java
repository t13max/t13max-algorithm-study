package com.t13max.design.builder;

/**
 * @Author 呆呆
 * @Datetime 2022/4/18 7:46
 */
public class Main {

    public static void main(String[] args) {
        Director director = new Director();

        Builder builder1 = new ConcreteBuilder1();
        Builder builder2 = new ConcreteBuilder2();

        director.construct(builder1);
        Product p1 = builder1.getResult();
        p1.show();
    }
}
