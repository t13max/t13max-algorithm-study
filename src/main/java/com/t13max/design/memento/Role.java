package com.t13max.design.memento;

/**
 * @Author 呆呆
 * @Datetime 2022/4/19 7:58
 */
public class Role {

    private int atk;

    private int hp;

    private int def;

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

    public RoleStateMemento save() {
        return new RoleStateMemento(this.atk, this.hp, this.def);
    }

    public void recover(RoleStateMemento memento) {
        this.atk = memento.getAtk();
        this.hp = memento.getHp();
        this.def = memento.getDef();
    }
}
