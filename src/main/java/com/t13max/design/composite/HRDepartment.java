package com.t13max.design.composite;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 7:30
 */
public class HRDepartment extends Company {

    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        System.out.println("-" + depth + getName());
    }

    @Override
    public void lineOfDuty() {
        System.out.println("hr");
    }
}
