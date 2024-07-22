package com.t13max.design.composite;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 7:42
 */
public class FinanceDepartment extends Company {

    public FinanceDepartment(String name) {
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
        System.out.println("财务");
    }
}
