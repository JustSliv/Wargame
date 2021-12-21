package com.war.heroes;

import com.war.weapons.Weapon;

public class Vampire extends Warrior {

    protected int vampirism;

    public Vampire() {
        health = 40;
        maxHealth = 40;
        attack = 4;
        vampirism = 50;
    }

    public int healWithVampirism(int attack) {
        int healResult = Math.round(((float) attack * vampirism) / 100);

        if (this.getHealth() + healResult >= this.getMaxHealth()) {
            this.setHealth(this.getMaxHealth());
        } else {
            this.setHealth(this.getHealth() + healResult);
        }

        return healResult;
    }

    public int getVampirism() {
        return vampirism;
    }

    public int doAttack(Hero enemy) {
        int finalAttack = 0;
//        if (enemy == this) throw new SelfAttackException("You can't attack yourself");

        finalAttack = (this.getAttack() - enemy.getDefence());

        enemy.setHealth(enemy.getHealth() - finalAttack);

        healWithVampirism(finalAttack);

        return finalAttack;
    }

    public int addVampirism(int vampirism) {
        this.vampirism = (getVampirism() + vampirism);
        return getVampirism();
    }

    @Override
    protected void applyWeapon(Weapon weapon) {
        if (maxHealth >= 0) {
            addHealth(weapon.getHealth());
        }
        if (attack >= 0) {
            addAttack(weapon.getAttack());
        }
        if (vampirism >= 0) {
            addVampirism(weapon.getVampirism());
        }
    }

    @Override
    public String toString() {
        return "Vampire{" +
                "health=" + health +
                ", attack=" + attack +
                ", defence=" + defence +
                ", maxHealth=" + maxHealth +
                ", vampirism=" + vampirism +
                '}';
    }
}
