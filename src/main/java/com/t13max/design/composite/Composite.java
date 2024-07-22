package com.t13max.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 将对象组合成树形结构
 * @Author 呆呆
 * @Datetime 2022/4/20 7:09
 */
public class Composite extends Component {

    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println("-" + depth + getName());
        for (Component child : children) {
            child.display(depth + 2);
        }
    }
}
