package com.t13max.design.composite;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 7:26
 */
public abstract class Company {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void add(Company company);

    public abstract void remove(Company company);

    public abstract void display(int depth);

    public abstract void lineOfDuty();

}
