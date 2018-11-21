/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leagueoflegends.champions;


public class TrundleBuilder {

    private int health;
    private int mana;
    private int[] abilities;
    private double healthGrowth;
    private double manaGrowth;
    private double healthRegen;
    private double manaRegen;
    private double movementSpeed;
    private int attackRange;
    private int armor;
    private int magicResistance;

    public TrundleBuilder() {
    }

    public TrundleBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    public TrundleBuilder setMana(int mana) {
        this.mana = mana;
        return this;
    }

    public TrundleBuilder setAbilities(int[] abilities) {
        this.abilities = abilities;
        return this;
    }

    public TrundleBuilder setHealthGrowth(double healthGrowth) {
        this.healthGrowth = healthGrowth;
        return this;
    }

    public TrundleBuilder setManaGrowth(double manaGrowth) {
        this.manaGrowth = manaGrowth;
        return this;
    }

    public TrundleBuilder setHealthRegen(double healthRegen) {
        this.healthRegen = healthRegen;
        return this;
    }

    public TrundleBuilder setManaRegen(double manaRegen) {
        this.manaRegen = manaRegen;
        return this;
    }

    public TrundleBuilder setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
        return this;
    }

    public TrundleBuilder setAttackRange(int attackRange) {
        this.attackRange = attackRange;
        return this;
    }

    public TrundleBuilder setArmor(int armor) {
        this.armor = armor;
        return this;
    }

    public TrundleBuilder setMagicResistance(int magicResistance) {
        this.magicResistance = magicResistance;
        return this;
    }

    public Trundle createTrundle() {
        return new Trundle(health, mana, abilities, healthGrowth, manaGrowth, healthRegen, manaRegen, movementSpeed, attackRange, armor, magicResistance);
    }
    
}
