package com.t13max.design.decorator;

/**
 * @Author 呆呆
 * @Datetime 2022/4/9 14:52
 */
public class Finery extends Person {

    private Person person;

    public Finery(Person person) {
        this.person = person;
    }


    @Override
    public void show() {
        if (person != null) {
            person.show();
        }
    }
}
