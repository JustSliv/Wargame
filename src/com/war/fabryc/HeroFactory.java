package com.war.fabryc;

import com.war.heroes.Hero;
import com.war.heroes.Knight;
import com.war.heroes.Warrior;

public class HeroFactory {
    public Hero getHero(HeroTypes type) {
        Hero heroToReturn = null;
        switch (type) {
            case KNIGHT -> heroToReturn = new Knight();
            case WARRIOR -> heroToReturn = new Warrior();
            default -> throw new IllegalArgumentException("Wrong hero type" + type);
        }
        return heroToReturn;
    }
}
