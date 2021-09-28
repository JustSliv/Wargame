package com.war.heroes;

import com.war.exceptions.OverHealException;
import com.war.exceptions.SelfAttackException;

public abstract class Hero {

    protected int health;
    protected int attack;
    protected int defence;
    protected int vampirism;
    protected int maxHealth;

    public boolean isAlive() {
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getVampirism() {
        return vampirism;
    }

    public void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int doAttack(Hero enemy) throws SelfAttackException {
        int finalAttack = 0;
        if (enemy == this) throw new SelfAttackException("You can't attack yourself");

        finalAttack = (this.getAttack() - enemy.getDefence());
        enemy.setHealth(enemy.getHealth() - finalAttack);

        healWithVampirism(finalAttack);

        return finalAttack;
    }

    public int healWithVampirism(int attack) {
        int healResult = Math.round(((float) attack * vampirism) / 100);

        try {
            heal(healResult);
        } catch (OverHealException exception) {
            System.out.println(exception.getMessage());
            return 0;
        }

        return healResult;
    }

    public void heal(int heal) throws OverHealException {
        if (this.getHealth() + heal > this.getMaxHealth())
            throw new OverHealException("You can't heal over your health");

        this.setHealth(this.getHealth() + heal);
    }

}
