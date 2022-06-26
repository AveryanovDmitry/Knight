package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.ammunition.DefaultValueAmmunition;

/**
 * Generates knight with some ammunition.
 */
public class KnightGenerator {
    /**
     * Use it to quickly generate knight
     *
     * @return knight
     */
    public Knight generateKnight() {
        AmmunitionGenerator generator = new AmmunitionGenerator();
        DefaultValueAmmunition defaultValue = new DefaultValueAmmunition();
        Knight knight = new Knight();
        int[] statsDefaultSword = {defaultValue.getDamageSword(),
                defaultValue.getWeightSword(), defaultValue.getCostSword()};
        int[] statsDefaultHelmet = {defaultValue.getProtectionHelmet(),
                defaultValue.getWeightHelmet(), defaultValue.getCostHelmet()};
        knight.equip(generator.generateAmmunition(
                AmmunitionType.SWORD, statsDefaultSword));
        knight.equip(generator.generateAmmunition(
                AmmunitionType.HELMET, statsDefaultHelmet));
        return knight;
    }
}
