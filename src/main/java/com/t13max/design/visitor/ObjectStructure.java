package com.t13max.design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 呆呆
 * @Datetime 2022/4/22 7:24
 */
public class ObjectStructure {

    private List<Person> elements = new ArrayList<>();

    public boolean add(Person person) {
        return elements.add(person);
    }

    public boolean remove(Person person) {
        return elements.remove(person);
    }

    public void display(Action action) {
        for (Person element : this.elements) {
            element.accept(action);
            System.out.println();
        }
    }
}
