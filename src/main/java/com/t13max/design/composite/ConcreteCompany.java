package com.t13max.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 7:28
 */
public class ConcreteCompany extends Company {

    private List<Company> companyList = new ArrayList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        companyList.add(company);
    }

    @Override
    public void remove(Company company) {
        companyList.remove(company);
    }

    @Override
    public void display(int depth) {
        System.out.println("-" + depth + getName());
        for (Company company : companyList) {
            company.display(depth + 2);
        }
    }

    @Override
    public void lineOfDuty() {
        for (Company company : companyList) {
            company.lineOfDuty();
        }
    }
}
