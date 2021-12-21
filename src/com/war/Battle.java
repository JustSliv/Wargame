package com.war;

import com.war.heroes.Healer;
import com.war.heroes.Hero;
import com.war.heroes.MultiAttacker;

import static java.lang.Math.min;

public class Battle {

    public static boolean fight(Hero hero1, Hero hero2) {
        int round = 1;
        while (hero1.isAlive() && hero2.isAlive()) {
            if (hero1 instanceof Healer && hero2 instanceof Healer) {
                hero1.setAlive(false);
                hero2.setAlive(false);
                break;
            }

            if (round % 2 != 0) {
                hero1.doAttack(hero2);
            } else {
                hero2.doAttack(hero1);
            }
            round++;
        }
        if(!hero1.isAlive()) hero1.setAlive(false);
        if(!hero2.isAlive()) hero2.setAlive(false);

        return hero1.isAlive();

    }

    private static void pierceFight(MultiAttacker hero, Army army) {
        hero.doAttack(army);
    }

    private static void healArmy(Army army) {
        if (1 < army.size()) {
            if ((army.getHero(1)) instanceof Healer) {
                Healer healer = (Healer) army.getHealer();
                healer.healAlly(army.peekHero());
            }
        }
    }

    public static boolean fight(Army army1, Army army2) {
        int round = 1;

        while (!army1.isEmpty() && !army2.isEmpty()) {
            if (round % 2 != 0) {
                if (army1.peekHero().isAlive()) {
                    if (army1.peekHero() instanceof MultiAttacker) {
                        pierceFight((MultiAttacker) army1.peekHero(), army2);
                        healArmy(army1);
                    } else {
                        army1.peekHero().doAttack(army2.peekHero());
                        healArmy(army1);
                    }
                } else {
                    army1.pollHero();
                }

            } else {
                if (army2.peekHero().isAlive()) {
                    if (army2.peekHero() instanceof MultiAttacker) {
                        pierceFight((MultiAttacker) army2.peekHero(), army1);
                        healArmy(army2);
                    } else {
                        army2.peekHero().doAttack(army1.peekHero());
                        healArmy(army2);
                    }
                } else {
                    army2.pollHero();
                }

            }
            round++;
        }
        return !army1.isEmpty();
    }

    public static boolean straightFight(Army army1, Army army2) {
        while (army1.hasAliveFighters() && army2.hasAliveFighters()) {
            int minSize = min(army1.size(), army2.size());

            for (int i = 0; i < minSize; i++) {
                if(army1.getHero(i) instanceof Healer && army2.getHero(i) instanceof Healer){
                    army1.getHero(i).setAlive(false);
                    army2.getHero(i).setAlive(false);
                    break;
                }
                fight(army1.getHero(i), army2.getHero(i));
            }
        }
        return army1.hasAliveFighters();
    }

}