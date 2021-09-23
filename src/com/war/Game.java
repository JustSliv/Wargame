package com.war;

import com.war.Exceptions.SelfAttackException;

public class Game {

    public static boolean fight(Hero hero1, Hero hero2){
        int round = 1;

        try{
            while(hero1.isAlive() && hero2.isAlive()){

                if(round % 2 != 0){
                    hero1.doAttack(hero2);
                }
                else {
                    hero2.doAttack(hero1);
                }
                round++;
            }
        }catch (SelfAttackException exception){
            exception.getMessage();
        }

        return hero1.isAlive();

    }
}