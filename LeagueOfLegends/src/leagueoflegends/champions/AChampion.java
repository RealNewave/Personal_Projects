/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leagueoflegends.champions;

/**
 *
 * @author Hans
 */
public abstract class AChampion {
    
    int health;
    int mana;
    int[] abilities;
    double healthGrowth;
    double manaGrowth;
    double healthRegen;
    double manaRegen;
    double movementSpeed;
    int attackRange;
    int armor;
    int magicResistance;

    public AChampion(int health, int mana, int[] abilities, double healthGrowth, double manaGrowth, double healthRegen, double manaRegen, double movementSpeed, int attackRange, int armor, int magicResistance) {
        this.health = health;
        this.mana = mana;
        this.abilities = abilities;
        this.healthGrowth = healthGrowth;
        this.manaGrowth = manaGrowth;
        this.healthRegen = healthRegen;
        this.manaRegen = manaRegen;
        this.movementSpeed = movementSpeed;
        this.attackRange = attackRange;
        this.armor = armor;
        this.magicResistance = magicResistance;
    }

    

    

    
    
    
}
