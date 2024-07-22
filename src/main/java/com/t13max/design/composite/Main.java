package com.t13max.design.composite;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 7:11
 */
public class Main {

    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("leaf A"));
        root.add(new Leaf("leaf B"));

        Composite comp = new Composite("Composite X");
        comp.add(new Leaf("leaf XA"));
        comp.add(new Leaf("leaf XB"));
        root.add(comp);

        Composite comp2 = new Composite("Composite XY");
        comp2.add(new Leaf("leaf XYA"));
        comp2.add(new Leaf("leaf XYB"));
        comp.add(comp2);

        root.display(1);
    }
}
