package com.t13max.design.decorator;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:56
 */
public class BigTrouser extends Finery {

    public BigTrouser(Person person) {
        super(person);
    }

    @Override
    public void show() {
        System.out.println("BigTrouser");
        super.show();
    }
}
