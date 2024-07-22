package com.t13max.design.decorator;

/**
 * 为已有的功能动态添加更多功能
 *
 * @Author 呆呆
 * @Datetime 2022/4/9 14:58
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person("庞庞");
        TShirts tShirts = new TShirts(person);
        BigTrouser bigTrouser = new BigTrouser(tShirts);
        bigTrouser.show();
    }
}
