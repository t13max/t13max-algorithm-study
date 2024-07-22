package com.t13max.design.composite;

/**
 * @Author 呆呆
 * @Datetime 2022/4/20 7:08
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("can not add to a leaf");
    }

    @Override
    public void remove(Component component) {
        System.out.println("can not remove from a leaf");
    }

    @Override
    public void display(int depth) {
        System.out.println("-" + depth + getName());
    }
}
