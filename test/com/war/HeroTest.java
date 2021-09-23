package com.war;

import com.war.Exceptions.SelfAttackException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    @DisplayName("Warrior attack knight one time assume knight has 45 health")
    void doAttack() throws SelfAttackException {
        Hero warrior = new Warrior();
        Hero enemy = new Knight();

        var result = warrior.doAttack(enemy);

        assertEquals(result, 45);
    }

    @Test
    @DisplayName("Warrior attack warrior three times assume knight has 35 health")
    void doAttack2() throws SelfAttackException {
        Hero warrior = new Warrior();
        Hero enemy = new Knight();
        int result = 0;

        for (int i = 0; i < 3; i++) {
             result = warrior.doAttack(enemy);
        }

        assertEquals(result, 35);
    }

    @Test
    @DisplayName("Hero with full health")
    void isAlive1() {
        Hero warrior = new Warrior();

        var result = warrior.isAlive();

        assertTrue(result);
    }

    @Test
    @DisplayName("Hero with health > 0")
    void isAlive2() throws SelfAttackException {
        Hero warrior = new Warrior();
        Hero warrior2 = new Warrior();

        warrior.setHealth(warrior2.doAttack(warrior));
        var result = warrior.isAlive();

        assertTrue(result);
    }

    @Test
    @DisplayName("Hero with health = 0")
    void isAlive3() {
        Hero warrior = new Warrior();

        warrior.setHealth(0);
        var result = warrior.isAlive();

        assertFalse(result);
    }

    @Test
    @DisplayName("Hero with health <= 0")
    void isAlive4() {
        Hero warrior = new Warrior();

        warrior.setHealth(-5);
        var result = warrior.isAlive();

        assertFalse(result);
    }

}