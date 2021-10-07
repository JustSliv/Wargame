package com.war;

import com.war.exceptions.SelfAttackException;
import com.war.fabryc.HeroTypes;
import com.war.heroes.*;
import com.war.weapons.*;
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
    @DisplayName("fight warrior vs lancer assume second win")
    void fight8() {
        Hero warrior = new Warrior();
        Hero lancer = new Lancer();

        var result = Battle.fight(warrior, lancer);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("fight healer vs healer assume second win")
    void fight9() {
        Hero hero1 = new Healer();
        Hero hero2 = new Healer();

        var result = Battle.fight(hero1, hero2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("20 warriors vs 5 warriors assume first army win")
    void armyFight1() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 20);
        army2.addUnits(HeroTypes.WARRIOR, 5);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("5 warriors vs 5 warriors assume first army win")
    void armyFight2() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 5);
        army2.addUnits(HeroTypes.WARRIOR, 5);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("5 warriors vs 20 warriors assume second army win")
    void armyFight3() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 5);
        army2.addUnits(HeroTypes.WARRIOR, 20);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("5 warriors vs 7 warriors assume second army win")
    void armyFight4() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 5);
        army2.addUnits(HeroTypes.WARRIOR, 7);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("20 warriors vs 21 warriors assume second army win")
    void armyFight5() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 20);
        army2.addUnits(HeroTypes.WARRIOR, 21);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("10 warriors vs 11 warriors assume second army win")
    void armyFight6() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 10);
        army2.addUnits(HeroTypes.WARRIOR, 11);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("11 warriors vs 7 warriors assume first army win")
    void armyFight7() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.WARRIOR, 11);
        army2.addUnits(HeroTypes.WARRIOR, 7);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Vampire vs warrior assume first win")
    void vampireFight() {
        Hero vampire = new Vampire();
        Hero warrior = new Warrior();

        var result = (Battle.fight(vampire, warrior));

        assertEquals(result, true);
    }


    @Test
    @DisplayName("Army 1(7 lancer, 3 vampire, 4 warrior, 2 defender) " +
            "vs army 2 (4 warrior, 4 defender, 6 vampire, 4 lancer) assume win army 1")
    void armyFight8() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.LANCER, 7);
        army1.addUnits(HeroTypes.VAMPIRE, 3);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.DEFENDER, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army2.addUnits(HeroTypes.VAMPIRE, 6);
        army2.addUnits(HeroTypes.LANCER, 4);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Army 1(3 vampires, 8 warriors, 9 defenders) " +
            "vs army 2 (4 warriors, 4 defenders, 13 vampires) assume win army 1")
    void armyFight9() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.VAMPIRE, 3);
        army1.addUnits(HeroTypes.WARRIOR, 8);
        army1.addUnits(HeroTypes.DEFENDER, 9);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army2.addUnits(HeroTypes.VAMPIRE, 13);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Army 1(3 vampires, 4 warriors, 2 defenders) " +
            "vs army 2 (4 warriors, 4 defenders, 3 vampires) assume win army 2")
    void armyFight10() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();


        army1.addUnits(HeroTypes.VAMPIRE, 3);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.DEFENDER, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army2.addUnits(HeroTypes.VAMPIRE, 3);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("Army 1(5 lancer, 3 vampire, 4 warrior, 2 defender) " +
            "vs army 2 (4 warrior, 4 defender, 6 vampire, 5 lancer) assume win army 2")
    void armyFight11() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.LANCER, 5);
        army1.addUnits(HeroTypes.VAMPIRE, 3);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.DEFENDER, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army2.addUnits(HeroTypes.VAMPIRE, 6);
        army2.addUnits(HeroTypes.LANCER, 5);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("Army 1(7 lancer, 3 vampire, 1 healer, 4 warrior, 1 healer, 6 vampire, 2 defender) " +
            "vs army 2 (4 warrior, 4 defender, 1 healer, 6 vampire, 4 lancer) assume win army 1")
    void armyFight12() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.LANCER, 7);
        army1.addUnits(HeroTypes.VAMPIRE, 3);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.VAMPIRE, 6);
        army1.addUnits(HeroTypes.DEFENDER, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army1.addUnits(HeroTypes.HEALER, 1);
        army2.addUnits(HeroTypes.VAMPIRE, 6);
        army2.addUnits(HeroTypes.LANCER, 4);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Army 1(1 lancer, 3 warrior, 1 healer, 4 warrior, 1 healer, 2 knight) " +
            "vs army 2 (4 warrior, 4 defender, 1 healer, 6 vampire, 4 lancer) assume win army 2")
    void armyFight13() throws SelfAttackException {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.LANCER, 1);
        army1.addUnits(HeroTypes.WARRIOR, 3);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.KNIGHT, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army1.addUnits(HeroTypes.HEALER, 1);
        army2.addUnits(HeroTypes.VAMPIRE, 6);
        army2.addUnits(HeroTypes.LANCER, 4);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("Defender with weapon(Health = -10, attack = 5, defense = 0, vampirism = 40, healPower = 0) " +
            "vs vampire with Sword(health = 5, attack = 2) assume first win")
    void weaponTest1() {
        Hero defender = new Defender();
        Hero vampire = new Vampire();

        Weapon weapon1 = new Weapon(-10, 5, 0, 40, 0);
        Weapon weapon2 = new Sword();

        defender.addWeapon(weapon1);
        vampire.addWeapon(weapon2);

        var result = Battle.fight(defender, vampire);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Defender with shield vs Lancer with GreatAxe assume second win")
    void weaponTest2() {
        Hero hero1 = new Defender();
        Hero hero2 = new Lancer();

        Weapon weapon1 = new Shield();
        Weapon weapon2 = new GreatAxe();

        hero1.addWeapon(weapon1);
        hero2.addWeapon(weapon2);

        var result = Battle.fight(hero1, hero2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("Healer with MagicWand vs Knight with Katana assume second win")
    void weaponTest3() {
        Hero hero1 = new Healer();
        Hero hero2 = new Knight();

        Weapon weapon1 = new MagicWand();
        Weapon weapon2 = new Katana();


        hero1.addWeapon(weapon1);
        hero2.addWeapon(weapon2);


        var result = Battle.fight(hero1, hero2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("Defender with Shield and MagicWand vs Vampire with Shield and Katana assume second win")
    void weaponTest4() {
        Hero hero1 = new Defender();
        Hero hero2 = new Vampire();

        Weapon weapon1 = new Shield();
        Weapon weapon2 = new MagicWand();
        Weapon weapon3 = new Shield();
        Weapon weapon4 = new Katana();


        hero1.addWeapon(weapon1);
        hero1.addWeapon(weapon2);
        hero2.addWeapon(weapon3);
        hero2.addWeapon(weapon4);


        var result = Battle.fight(hero1, hero2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("Knight with MagicWand and Lancer GreatAxe vs Vampire with MagicWand and Healer with GreatAxe assume first win")
    void weaponTest5() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.KNIGHT, 1);
        army1.addUnits(HeroTypes.LANCER, 1);

        army2.addUnits(HeroTypes.VAMPIRE, 1);
        army2.addUnits(HeroTypes.HEALER, 1);

        Weapon weapon1 = new MagicWand();
        Weapon weapon2 = new GreatAxe();


        army1.getHero(0).addWeapon(weapon1);
        army1.getHero(1).addWeapon(weapon2);
        army2.getHero(0).addWeapon(weapon1);
        army2.getHero(1).addWeapon(weapon2);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Defender with Sword and Warrior GreatAxe vs Knight with Sword and Healer GreatAxe assume first win")
    void weaponTest6() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.DEFENDER, 1);
        army1.addUnits(HeroTypes.WARRIOR, 1);

        army2.addUnits(HeroTypes.KNIGHT, 1);
        army2.addUnits(HeroTypes.HEALER, 1);

        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();


        army1.getHero(0).addWeapon(weapon1);
        army1.getHero(0).addWeapon(weapon2);
        army2.getHero(0).addWeapon(weapon1);
        army2.getHero(0).addWeapon(weapon2);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("2 Defender with Katana vs Knight with Katana and Vampire with Katana assume second win")
    void weaponTest7() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.DEFENDER, 2);

        army2.addUnits(HeroTypes.KNIGHT, 1);
        army2.addUnits(HeroTypes.VAMPIRE, 1);

        Weapon weapon1 = new Katana();

        army1.getHero(0).addWeapon(weapon1);
        army1.getHero(1).addWeapon(weapon1);
        army2.getHero(0).addWeapon(weapon1);
        army2.getHero(1).addWeapon(weapon1);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }
    @Test
    @DisplayName("3 Knights with custom weapon " +
            "vs Warrior with custom weapon and 2 Defender with custom weapon assume first win")
    void weaponTest8() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.KNIGHT, 3);

        army2.addUnits(HeroTypes.WARRIOR, 1);
        army2.addUnits(HeroTypes.DEFENDER, 2);

        Weapon weapon1 = new Weapon(-20, 6, 1, 40, -2);
        Weapon weapon2 = new Weapon(20, -2, 2, -55, 3);

        army1.getHero(0).addWeapon(weapon1);
        army1.getHero(1).addWeapon(weapon1);
        army1.getHero(2).addWeapon(weapon2);
        army2.getHero(0).addWeapon(weapon1);
        army2.getHero(1).addWeapon(weapon2);
        army2.getHero(2).addWeapon(weapon2);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }
    @Test
    @DisplayName("3 Vampire with custom weapon" +
            " vs Warrior with custom weapon and 2 Defender with custom weapon assume second win")
    void weaponTest9() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.VAMPIRE, 3);

        army2.addUnits(HeroTypes.WARRIOR, 1);
        army2.addUnits(HeroTypes.DEFENDER, 2);

        Weapon weapon1 = new Weapon(-20, 1, 1, 40, -2);
        Weapon weapon2 = new Weapon(20, 2, 2, -55, 3);

        army1.getHero(0).addWeapon(weapon1);
        army1.getHero(1).addWeapon(weapon1);
        army1.getHero(2).addWeapon(weapon2);
        army2.getHero(0).addWeapon(weapon1);
        army2.getHero(1).addWeapon(weapon2);
        army2.getHero(2).addWeapon(weapon2);


        var result = Battle.fight(army1, army2);

        assertEquals(result, false);
    }
    @Test
    @DisplayName("3 Vampire with GreatAxe" +
            " vs Warrior with Sword and Defender with Sword assume first win")
    void weaponTest10() {
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.VAMPIRE, 3);

        army2.addUnits(HeroTypes.WARRIOR, 1);
        army2.addUnits(HeroTypes.DEFENDER, 1);

        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();

        army1.getHero(0).addWeapon(weapon2);
        army1.getHero(1).addWeapon(weapon2);
        army1.getHero(2).addWeapon(weapon2);
        army2.getHero(0).addWeapon(weapon1);
        army2.getHero(1).addWeapon(weapon1);


        var result = Battle.fight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Straight fight army1(5 Lancer, 3 Vampire, 4 Warrior, 2 Defender vs army2(4 Warrior, 4 Defender, 6 Vampire, 5 Lancer)")
    void straightFight1(){
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.LANCER, 5);
        army1.addUnits(HeroTypes.VAMPIRE, 3);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.DEFENDER, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army2.addUnits(HeroTypes.VAMPIRE, 6);
        army2.addUnits(HeroTypes.LANCER, 5);

        var result = Battle.straightFight(army1, army2);

        assertEquals(result, false);
    }
    @Test
    @DisplayName("Straight fight army1(7 Lancer, 3 Vampire, 4 Warrior, 2 Defender vs army2(4 Warrior, 4 Defender, 6 Vampire, 4 Lancer)")
    void straightFight2(){
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.LANCER, 7);
        army1.addUnits(HeroTypes.VAMPIRE, 3);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.DEFENDER, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army2.addUnits(HeroTypes.VAMPIRE, 6);
        army2.addUnits(HeroTypes.LANCER, 4);

        var result = Battle.straightFight(army1, army2);

        assertEquals(result, true);
    }

    @Test
    @DisplayName("Straight fight army1(7 Lancer, 3 Vampire, 1 Healer, 4 Warrior, 1 Healer, 2 Defender " +
            "vs army2(4 Warrior, 4 Defender,1 Healer, 6 Vampire, 4 Lancer)")
    void straightFight3(){
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.LANCER, 7);
        army1.addUnits(HeroTypes.VAMPIRE, 3);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.DEFENDER, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army2.addUnits(HeroTypes.HEALER, 1);
        army2.addUnits(HeroTypes.VAMPIRE, 6);
        army2.addUnits(HeroTypes.LANCER, 4);

        var result = Battle.straightFight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("Straight fight army1(7 Lancer, 3 Vampire, 1 Healer, 4 Warrior, 1 Healer, 2 Defender " +
            "vs army2(4 Warrior, 4 Defender,1 Healer, 6 Vampire, 4 Lancer)")
    void straightFight4(){
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.LANCER, 7);
        army1.addUnits(HeroTypes.VAMPIRE, 3);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.DEFENDER, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army2.addUnits(HeroTypes.HEALER, 1);
        army2.addUnits(HeroTypes.VAMPIRE, 6);
        army2.addUnits(HeroTypes.LANCER, 4);

        var result = Battle.straightFight(army1, army2);

        assertEquals(result, false);
    }

    @Test
    @DisplayName("Straight fight army1(7 Lancer, 3 Vampire, 1 Healer, 4 Warrior, 1 Healer, 2 Defender " +
            "vs army2(4 Warrior, 4 Defender,1 Healer, 6 Vampire, 4 Lancer)")
    void straightFight5(){
        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(HeroTypes.LANCER, 4);
        army1.addUnits(HeroTypes.WARRIOR, 3);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.WARRIOR, 4);
        army1.addUnits(HeroTypes.HEALER, 1);
        army1.addUnits(HeroTypes.KNIGHT, 2);

        army2.addUnits(HeroTypes.WARRIOR, 4);
        army2.addUnits(HeroTypes.DEFENDER, 4);
        army2.addUnits(HeroTypes.HEALER, 1);
        army2.addUnits(HeroTypes.VAMPIRE, 2);
        army2.addUnits(HeroTypes.LANCER, 4);

        var result = Battle.straightFight(army1, army2);

        assertEquals(result, true);
    }

}

