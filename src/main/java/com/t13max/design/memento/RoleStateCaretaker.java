package com.t13max.design.memento;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 8:01
 */
public class RoleStateCaretaker {

    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
