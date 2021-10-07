package com.war;

import com.war.heroes.Healer;
import com.war.heroes.Hero;
import com.war.heroes.MultiAttacker;

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

        return hero1.isAlive();

    }

    private static void pierceFight(MultiAttacker hero, Army army) {
        hero.doAttack(army);
//        army.peekHero().doAttack((Hero) hero);
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

        while (army1.hasAliveFighters() && army2.hasAliveFighters()) {
            if (round % 2 != 0) {
                if(army1.peekHero().isAlive()){
                    if (army1.peekHero() instanceof MultiAttacker) {
                        pierceFight((MultiAttacker) army1.peekHero(), army2);
                        healArmy(army1);
                    } else {
                        army1.peekHero().doAttack(army2.peekHero());
                        healArmy(army1);
                    }
                }else{
                    army1.pollHero();
                }

            } else {
                if(army2.peekHero().isAlive()){
                    if (army2.peekHero() instanceof MultiAttacker) {
                        pierceFight((MultiAttacker) army2.peekHero(), army1);
                        healArmy(army2);
                    } else {
                        army2.peekHero().doAttack(army1.peekHero());
                        healArmy(army2);
                    }
                }else{
                    army2.pollHero();
                }

            }
            round++;
        }
        return army1.hasAliveFighters();
    }

//    public static boolean fight(Army army1, Army army2) {
//        int round = 1;
//        while (army1.hasAliveFighters() && army2.hasAliveFighters()) {
//            if (round % 2 != 0) {
//                healArmy(army1);
//                if (army1.peekHero() instanceof MultiAttacker) {
//                    pierceFight((MultiAttacker) army1.peekHero(), army2);
//                } else {
//                    if (fight(army1.peekHero(), army2.peekHero())) {
//                        army2.pollHero();
//                    } else {
//                        army1.pollHero();
//                    }
//                }
//            } else {
//                healArmy(army2);
//                if (army2.peekHero() instanceof MultiAttacker) {
//                    pierceFight((MultiAttacker) army2.peekHero(), army2);
//                } else {
//                    if (fight(army2.peekHero(), army1.peekHero())) {
//                        army1.pollHero();
//                    } else {
//                        army2.pollHero();
//                    }
//                }
//            }
//            round++;
//        }
//        return army1.hasAliveFighters();
//    }


}