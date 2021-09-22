package com.war;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    @DisplayName("fight warrior vs knight assume second win")
    void fight1() {
        Hero warrior = new Warrior();
        Hero knight = new Knight();

        var result = Game.fight(warrior, knight);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("fight warrior vs warrior assume first win")
    void fight2() {
        Hero warrior1 = new Warrior();
        Hero warrior2 = new Warrior();

        var result = Game.fight(warrior1, warrior2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("fight knight vs warrior assume first win")
    void fight3() {
        Hero knight = new Knight();
        Hero warrior = new Warrior();

        var result = Game.fight(knight, warrior);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("fight knight vs knight assume first win")
    void fight4() {
        Hero knight1 = new Knight();
        Hero knight2 = new Warrior();

        var result = Game.fight(knight1, knight2);

        assertEquals(result, true);
    }
}