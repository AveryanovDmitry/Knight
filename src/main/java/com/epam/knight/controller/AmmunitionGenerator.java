package com.epam.knight.controller;

import com.epam.knight.model.ammunition.AmmunitionType;
import com.epam.knight.model.ammunition.Helmet;
import com.epam.knight.model.ammunition.Sword;
import com.epam.knight.model.ammunition.Ammunition;

/**
 * Generates pieces of {@link Ammunition}.
 */
public class AmmunitionGenerator {
    private static final int COST = 2;
    private static final int WEIGHT = 1;
    private static final int PROPERTY = 0;

    public Ammunition generateAmmunition(AmmunitionType type, int[] stats) {
        Ammunition ammunition;

        if (AmmunitionType.HELMET == type) {
            ammunition = new Helmet();
        } else {
            ammunition = new Sword();
        }

        ammunition.setItemProperty(stats[PROPERTY]);
        ammunition.setWeight(stats[WEIGHT]);
        ammunition.setCost(stats[COST]);

        return ammunition;
    }
}

