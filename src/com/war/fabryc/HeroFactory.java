package com.war.fabryc;

import com.war.heroes.*;

public class HeroFactory {
    public Hero getHero(HeroTypes type) {
        Hero heroToReturn = null;
        switch (type) {
            case KNIGHT -> heroToReturn = new Knight();
            case WARRIOR -> heroToReturn = new Warrior();
            case DEFENDER -> heroToReturn = new Defender();
            case VAMPIRE -> heroToReturn = new Vampire();
            default -> throw new IllegalArgumentException("Wrong hero type" + type);
        }
        return heroToReturn;
    }
}
