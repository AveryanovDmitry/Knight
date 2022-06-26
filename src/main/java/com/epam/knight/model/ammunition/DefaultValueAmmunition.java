package com.epam.knight.model.ammunition;

public class DefaultValueAmmunition {
    private static final int DAMAGE_SWORD = 10;
    private static final int WEIGHT_SWORD = 20;
    private static final int COST_SWORD = 30;
    private static final int PROTECTION_HELMET = 30;
    private static final int WEIGHT_HELMET = 10;
    private static final int COST_HELMET = 20;

    public int getDamageSword() {
        return DAMAGE_SWORD;
    }

    public int getWeightSword() {
        return WEIGHT_SWORD;
    }

    public int getCostSword() {
        return COST_SWORD;
    }

    public int getProtectionHelmet() {
        return PROTECTION_HELMET;
    }

    public int getWeightHelmet() {
        return WEIGHT_HELMET;
    }

    public int getCostHelmet() {
        return COST_HELMET;
    }
}
