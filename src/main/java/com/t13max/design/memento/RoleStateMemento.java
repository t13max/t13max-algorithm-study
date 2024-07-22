package com.t13max.design.memento;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 8:00
 */
public class RoleStateMemento {

    private int atk;

    private int hp;

    private int def;

    public RoleStateMemento(int atk, int hp, int def) {
        this.atk = atk;
        this.hp = hp;
        this.def = def;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }


}
