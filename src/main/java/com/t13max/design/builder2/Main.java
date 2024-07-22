package com.t13max.design.builder2;

/**
 * ...
 *
 * @Author 呆呆
 * @Datetime 2022/4/18 7:54
 */
public class Main {

    public static void main(String[] args) {
        Person.Builder builder = Person.Builder.newBuilder();
        Person build = builder.age(1).id(1).build();
    }
}
