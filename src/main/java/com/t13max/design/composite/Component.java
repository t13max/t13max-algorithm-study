package com.t13max.design.composite;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 7:03
 */
public abstract class Component {

    private String name;

    public Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display(int depth);
}
