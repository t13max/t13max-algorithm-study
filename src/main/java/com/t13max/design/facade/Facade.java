package com.t13max.design.facade;

/**
 * @Author 呆呆
 * @Datetime 2022/4/18 7:20
 */
public class Facade {

    private SubSystemOne subSystemOne;

    private SubSystemTwo subSystemTwo;

    private SubSystemThree subSystemThree;

    public Facade() {
        this.subSystemOne = new SubSystemOne();
        this.subSystemTwo = new SubSystemTwo();
        this.subSystemThree = new SubSystemThree();
    }

    public void methodA() {
        System.out.println("methodA");
        subSystemOne.methodOne();
        subSystemThree.methodThree();
    }

    public void methodB() {
        System.out.println("methodB");
        subSystemTwo.methodTwo();
        subSystemOne.methodOne();
    }


}
