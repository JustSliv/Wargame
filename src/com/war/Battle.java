package com.war;

import com.war.exceptions.SelfAttackException;
import com.war.heroes.Hero;

public class Battle {

    public static boolean fight(Hero hero1, Hero hero2) {
        int round = 1;

        try {
            while (hero1.isAlive() && hero2.isAlive()) {

                if (round % 2 != 0) {
                    hero1.doAttack(hero2);
                } else {
                    hero2.doAttack(hero1);
                }
                round++;
            }
        } catch (SelfAttackException exception) {
            exception.getMessage();
        }

        return hero1.isAlive();

    }


    public static boolean fight(Army army1, Army army2) {
        int round = 1;

        while (army1.hasAliveFighters() && army2.hasAliveFighters()) {
            if (round % 2 != 0) {
                if (fight(army1.getHeroes().peek(), army2.getHeroes().peek())) {
                    army2.getHeroes().poll();
                } else {
                    army1.getHeroes().poll();
                }
            } else {
                if (fight(army2.getHeroes().peek(), army1.getHeroes().peek())) {
                    army1.getHeroes().poll();
                } else {
                    army2.getHeroes().poll();
                }
            }
            round++;
        }
        return army1.hasAliveFighters();
    }

}