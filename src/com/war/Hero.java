package com.war;

import com.war.Exceptions.SelfAttackException;

public abstract class Hero {

    protected int health;
    protected int attack;

    public boolean isAlive(){
        return this.health > 0;
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

    public int doAttack(Hero enemy) throws SelfAttackException {

        if(enemy == this) throw new SelfAttackException("You can't attack yourself");

        enemy.setHealth(enemy.getHealth() - this.getAttack());

        return enemy.getHealth();
    }
}
