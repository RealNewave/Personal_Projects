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
public class Trundle extends AChampion{
    
    
    public Trundle(int health, int mana, int[] abilities, double healthGrowth, double manaGrowth, double healthRegen, double manaRegen, double movementSpeed, int attackRange, int armor, int magicResistance) {
        super(health, mana, abilities, healthGrowth, manaGrowth, healthRegen, manaRegen, movementSpeed, attackRange, armor, magicResistance);
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int[] getAbilities() {
        return abilities;
    }

    public double getHealthGrowth() {
        return healthGrowth;
    }

    public double getManaGrowth() {
        return manaGrowth;
    }

    public double getHealthRegen() {
        return healthRegen;
    }

    public double getManaRegen() {
        return manaRegen;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getArmor() {
        return armor;
    }

    public int getMagicResistance() {
        return magicResistance;
    }
    
}
