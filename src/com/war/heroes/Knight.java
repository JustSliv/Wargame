package com.war.heroes;

public class Knight extends Hero {

    public Knight() {
        health = 50;
        maxHealth = 50;
        attack = 7;
    }

    @Override
    public String toString() {
        return "Knight{" +
                "health=" + health +
                ", attack=" + attack +
                ", defence=" + defence +
                ", maxHealth=" + maxHealth +
                ", isAlive=" + isAlive +
                '}';
    }
}
