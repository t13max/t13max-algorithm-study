package com.t13max.design.builder;

/**
 * @Author 呆呆
 * @Datetime 2022/4/18 7:44
 */
public class ConcreteBuilder2 extends Builder{

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("X");
    }

    @Override
    public void buildPartB() {
        product.add("Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
