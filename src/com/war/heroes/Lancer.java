package com.war.heroes;

import com.war.Army;

public class Lancer extends Warrior implements MultiAttacker {

    public Lancer() {
        health = 50;
        attack = 6;
    }

    @Override
    public void doAttack(Army army) {
            if (army.isEmpty()) {
                doAttack(army.getHero(0));
                if (army.size() > 1) {
                    doPierceAttack(army.getHero(1));
                }
            }
    }

    public void doPierceAttack(Hero enemy) {
        int finalAttack = 0;
        finalAttack = ((this.getAttack() - enemy.getDefence()) / 2);

        enemy.setHealth(enemy.getHealth() - finalAttack);

    }

    @Override
    public String toString() {
        return "Lancer{" +
                "health=" + health +
                ", attack=" + attack +
                ", defence=" + defence +
                ", maxHealth=" + maxHealth +
                '}';
    }
}
