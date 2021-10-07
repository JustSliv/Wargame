package com.war.heroes;

import com.war.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {

    protected int health;
    protected int attack;
    protected int defence;
    protected int maxHealth;
    protected boolean isAlive = true;
    private List<Weapon> weapons = new ArrayList<>();

    public boolean isAlive() {
        if(this.health > 0){
            isAlive = true;
        }else{
            isAlive = false;
        }
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
        health = 0;
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

    public int getDefence() {
        return defence;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }


    public int doAttack(Hero enemy) {
        int finalAttack = 0;
//        if (enemy == this) throw new SelfAttackException("You can't attack yourself");

        finalAttack = (this.getAttack() - enemy.getDefence());

        enemy.setHealth(enemy.getHealth() - finalAttack);

        return finalAttack;
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
        applyWeapon(weapon);
    }

    public int addHealth(int health) {
        this.maxHealth = getMaxHealth() + health;
        this.health =this.maxHealth;

        return getMaxHealth();
    }

    public int addAttack(int attack) {
        this.attack = getAttack() + attack;
        return getAttack();
    }

    public int addDefence(int defence) {
        this.defence = (getDefence() + defence);
        return getDefence();
    }

    protected void applyWeapon(Weapon weapon) {
        if (this.maxHealth > 0) {
            addHealth(weapon.getHealth());
        }else{
            this.attack = 0;
            this.isAlive = false;
        }
        if (this.attack > 0) {
            addAttack(weapon.getAttack());
        }
        if (this.defence > 0) {
            addDefence(weapon.getDefense());
        }
    }

}
