package com.war.heroes;

import com.war.weapons.Weapon;

public class Healer extends Hero {
    private int heal;

    public Healer() {
        health = 60;
        heal = 2;
    }

    public int getHeal() {
        return heal;
    }

    public void healAlly(Hero hero) {
        if (hero.getHealth() + this.heal >= hero.getMaxHealth()) {
            hero.setHealth(hero.getMaxHealth());
        } else {
            hero.setHealth(hero.getHealth() + this.heal);
        }
    }

    public int addHeal(int heal) {
        this.heal = (getHeal() + heal);
        return getHeal();
    }

    @Override
    protected void applyWeapon(Weapon weapon) {
        if (maxHealth > 0) {
            addHealth(weapon.getHealth());
        }else{
            this.heal = 0;
            this.isAlive = false;
        }
        if (heal > 0) {
            addHeal(weapon.getHealPower());
        }
    }
}
