package com.war.heroes;

public class Warrior extends Hero {

    public Warrior() {
        health = 50;
        maxHealth = 50;
        attack = 5;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "health=" + health +
                ", attack=" + attack +
                ", defence=" + defence +
                ", maxHealth=" + maxHealth +
                ", isAlive=" + isAlive +
                '}';
    }
}
