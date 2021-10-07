package com.war.heroes;

public class Defender extends Warrior{

    public Defender() {
        this.health = 60;
        maxHealth = 60;
        this.attack = 3;
        this.defence = 2;
    }

    @Override
    public String toString() {
        return "Defender{" +
                "health=" + health +
                ", attack=" + attack +
                ", defence=" + defence +
                ", maxHealth=" + maxHealth +
                '}';
    }
}
