package com.t13max.design.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 呆呆
 * @Datetime 2022/4/18 7:41
 */
public class Product {

    private List<String> parts = new ArrayList<>();

    public void add(String str) {
        parts.add(str);
    }

    public void show() {
        for (String part : this.parts) {
            System.out.println(part);
        }
    }
}
