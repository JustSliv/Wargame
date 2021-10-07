package com.war.weapons;

public class Weapon {
    protected int health;
    protected int attack;
    protected int defense;
    protected int vampirism;
    protected int healPower;

    public Weapon() {
    }

    public Weapon(int health, int attack, int defense, int vampirism, int healPower) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.vampirism = vampirism;
        this.healPower = healPower;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getVampirism() {
        return vampirism;
    }

    public int getHealPower() {
        return healPower;
    }
}
