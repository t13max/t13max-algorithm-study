package com.t13max.design.facade;

/**
 * 为子系统中的一组接口提供一个一致的界面
 * 分层
 * 一个外观类 对老代码提供简单接口 新系统与外观类交互
 * @Author 呆呆
 * @Datetime 2022/4/18 7:23
 */
public class Main {

    public static void main(String[] args) {
        Facade facade=new Facade();

        facade.methodA();
        facade.methodB();
    }
}
