package com.war;

public class Game {

    public static boolean fight(Hero hero1, Hero hero2){
        int round = 1;
        while(hero1.isAlive() && hero2.isAlive()){

            if(round % 2 != 0){
                hero2.setHealth(hero2.getHealth() - hero1.getAttack());
            }
            else {
                hero1.setHealth(hero1.getHealth() - hero2.getAttack());
            }
            round++;
        }
        return hero1.isAlive();

    }
}