package com.war;

public abstract class Hero {

    protected int health;
    protected int attack;

    public boolean isAlive(){
        return this.health >= 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
