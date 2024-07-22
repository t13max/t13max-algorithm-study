package com.t13max.design.decorator;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:49
 */
public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(name + "的装扮");
    }
}
