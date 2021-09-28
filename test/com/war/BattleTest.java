package com.war;

import com.war.exceptions.OverHealException;
import com.war.exceptions.SelfAttackException;
import com.war.fabryc.HeroTypes;
import com.war.heroes.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleTest {

    @Test
    @DisplayName("fight warrior vs knight assume second win")
    void fight1() {
        Hero warrior = new Warrior();
        Hero knight = new Knight();

        var result = Battle.fight(warrior, knight);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("fight warrior vs warrior assume first win")
    void fight2() {
        Hero warrior1 = new Warrior();
        Hero warrior2 = new Warrior();

        var result = Battle.fight(warrior1, warrior2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("fight knight vs warrior assume first win")
    void fight3() {
        Hero knight = new Knight();
        Hero warrior = new Warrior();

        var result = Battle.fight(knight, warrior);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("fight knight vs knight assume first win")
    void fight4() {
        Hero knight1 = new Knight();
        Hero knight2 = new Warrior();

        var result = Battle.fight(knight1, knight2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Test defence mechanic, Warrior attack Defender assume Warrior attack = 3")
    void fight5() throws SelfAttackException {
        Hero warrior = new Warrior();
        Hero defender = new Defender();

        var result = warrior.doAttack(defender);

        assertEquals(result, 3);
    }

    @Test
    @DisplayName("Test defence mechanic, Knight attack Defender assume Knight attack = 5")
    void fight6() throws SelfAttackException {
        Hero knight = new Knight();
        Hero defender = new Defender();

        var result = knight.doAttack(defender);

        assertEquals(result, 5);
    }

    @Test
    @DisplayName("Test defence mechanic, Defender attack Defender assume second hero attack = 1")
    void fight7() throws SelfAttackException {
        Hero defender1 = new Defender();
        Hero defender2 = new Defender();

        var result = defender1.doAttack(defender2);

        assertEquals(result, 1);
    }

    @Test
    @DisplayName("20 warriors vs 5 warriors assume first army win")
    void armyFight1() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 20);
        army2.addUnits(HeroTypes.WARRIOR, 5);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("5 warriors vs 5 warriors assume first army win")
    void armyFight2() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 5);
        army2.addUnits(HeroTypes.WARRIOR, 5);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("5 warriors vs 20 warriors assume second army win")
    void armyFight3() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 5);
        army2.addUnits(HeroTypes.WARRIOR, 20);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("5 warriors vs 7 warriors assume second army win")
    void armyFight4() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 5);
        army2.addUnits(HeroTypes.WARRIOR, 7);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("20 warriors vs 21 warriors assume second army win")
    void armyFight5() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 20);
        army2.addUnits(HeroTypes.WARRIOR, 21);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("10 warriors vs 11 warriors assume second army win")
    void armyFight6() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 10);
        army2.addUnits(HeroTypes.WARRIOR, 11);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("11 warriors vs 7 warriors assume first army win")
    void armyFight7() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 11);
        army2.addUnits(HeroTypes.WARRIOR, 7);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Vampirism not on full health")
    void vampirismTest() throws SelfAttackException, OverHealException {
        Hero vampire = new Vampire();
        Hero warrior = new Warrior();

        warrior.doAttack(vampire);

        var result = vampire.healWithVampirism(4);

        assertEquals(result, 2);
    }

    @Test
    @DisplayName("Vampirism on full health")
    void vampirismTest2() throws OverHealException {
        Hero vampire = new Vampire();
        Hero warrior = new Warrior();

        var result = vampire.healWithVampirism(4);

        assertEquals(result, 0);
    }

    @Test
    @DisplayName("Vampire vs warrior assume first win")
    void vampireFight() {
        Hero vampire = new Vampire();
        Hero warrior = new Warrior();

        var result = (Battle.fight(vampire, warrior));

        assertEquals(result, true);
    }
}