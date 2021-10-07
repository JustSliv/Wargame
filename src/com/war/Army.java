package com.war;

import com.war.fabryc.HeroFactory;
import com.war.fabryc.HeroTypes;
import com.war.heroes.Hero;

import java.util.Deque;
import java.util.LinkedList;

public class Army {
    private Deque<Hero> heroes = new LinkedList<>();

    public void addUnits(HeroTypes type, int number) {
        HeroFactory factory = new HeroFactory();
        for (int i = 0; i < number; i++) {
            heroes.addLast(factory.getHero(type));
        }
    }

    public int size() {
        return this.heroes.size();
    }

    public boolean isEmpty() {
        return size() > 0;
    }

    public Hero getHero(int id) {
        return ((LinkedList<Hero>) heroes).get(id);
    }

    public int getPositionOfCurrentHero() {
        return ((LinkedList<Hero>) heroes).indexOf(this.peekHero());
    }

    public Hero getHealer() {
        return getHero(getPositionOfCurrentHero() + 1);
    }

    public boolean hasAliveFighters() {
        return isEmpty();
    }

    public Hero peekHero() {
        return this.heroes.peek();
    }

    public Hero pollHero() {
        return this.heroes.poll();
    }

}
