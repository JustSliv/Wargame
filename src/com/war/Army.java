package com.war;

import com.war.fabryc.HeroFactory;
import com.war.fabryc.HeroTypes;
import com.war.heroes.Hero;

import java.util.ArrayDeque;
import java.util.Deque;

public class Army {
    private Deque<Hero> heroes = new ArrayDeque<Hero>();

    public Deque<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(Deque<Hero> heroes) {
        this.heroes = heroes;
    }

    public void addUnits(HeroTypes type, int number) {
        HeroFactory factory = new HeroFactory();
        for (int i = 0; i < number; i++) {
            heroes.addLast(factory.getHero(type));
        }
    }

    public boolean hasAliveFighters() {
        return this.heroes.size() > 0;
    }
}
