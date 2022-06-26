package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.AmmunitionType;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Manipulates with knight's ammunition and updates knight stats.
 */
public class KnightAmmunitionManager {

    private Knight knight;

    public KnightAmmunitionManager(Knight knight) {
        this.knight = knight;
    }

    public void equipAmmunitionToKnight(Ammunition item) {
        knight.equip(item);
        updateStats();
    }

    public int calculateAmmunitionWeight() {
        Ammunition[] ammunition = knight.getAmmunition();
        int sum = 0;
        for (Ammunition item: ammunition) {
            sum += item.getWeight();
        }
        return sum;
    }

    public int calculateAmmunitionCost() {
        Ammunition[] ammunition = knight.getAmmunition();
        int sum = 0;
        for (Ammunition item: ammunition) {
            sum += item.getCost();
        }
        return sum;
    }

    public int calculateAmmunitionDamage() {
        Ammunition[] ammunition = knight.getAmmunition();
        int sum = 0;
        for (Ammunition item: ammunition) {
            if (AmmunitionType.SWORD == item.getTypeAmmunition()) {
                sum += item.getValueProperty();
            }
        }
        return sum;
    }

    public int calculateAmmunitionProtection() {
        Ammunition[] ammunition = knight.getAmmunition();
        int sum = 0;
        for (Ammunition item: ammunition) {
            if (AmmunitionType.HELMET == item.getTypeAmmunition()) {
                sum += item.getValueProperty();
            }
        }
        return sum;
    }

    public void sortAmmunition(final int userChoice) {
        final int choiceCost = 1;
        final int choiceWeight = 2;

        if (userChoice >= choiceCost && userChoice <= choiceWeight) {
            Ammunition[] ammunitionSort = knight.getAmmunition();
            if (userChoice == choiceCost) {
                Arrays.sort(ammunitionSort,
                        Comparator.comparingInt(Ammunition::getCost));
            } else {
                Arrays.sort(ammunitionSort,
                        Comparator.comparingInt(Ammunition::getWeight));
            }
            knight.setAmmunition(ammunitionSort);
        }
    }

    public void updateStats() {
        knight.setCost(calculateAmmunitionCost());
        knight.setWeight(calculateAmmunitionWeight());
        knight.setDamage(calculateAmmunitionDamage());
        knight.setProtection(calculateAmmunitionProtection());
    }

    private Ammunition[] searchCost(int min, int max) {
        int amountEligibleAmmunition = 0;
        Ammunition[] searchCost;
        int iterator = 0;

        for (Ammunition item: knight.getAmmunition()) {
            if (item.getCost() >= min && item.getCost() <= max) {
                amountEligibleAmmunition++;
            }
        }
        searchCost = new Ammunition[amountEligibleAmmunition];

        for (Ammunition item: knight.getAmmunition()) {
            if (item.getCost() >= min && item.getCost() <= max) {
                searchCost[iterator] = item;
                iterator++;
            }
        }
        return searchCost;
    }

    private Ammunition[] searchWeight(int min, int max) {
        int amountEligibleAmmunition = 0;
        Ammunition[] searchWeight;
        int iterator = 0;

        for (Ammunition item: knight.getAmmunition()) {
            if (item.getWeight() >= min && item.getWeight() <= max) {
                amountEligibleAmmunition++;
            }
        }
        searchWeight = new Ammunition[amountEligibleAmmunition];

        for (Ammunition item: knight.getAmmunition()) {
            if (item.getWeight() >= min && item.getWeight() <= max) {
                searchWeight[iterator] = item;
                iterator++;
            }
        }
        return searchWeight;
    }

    public Ammunition[] searchAmmunition(int min, int max, int userChoice) {
        final int choiceCost = 1;
        final int choiceWeight = 2;
        int choiceWrongNumber = 0;
        Ammunition[] searchAmmunition;

        switch (userChoice) {
            case choiceCost:
                searchAmmunition = searchCost(min, max);
                break;
            case choiceWeight:
                searchAmmunition = searchWeight(min, max);
                break;
            default:
                searchAmmunition = new Ammunition[choiceWrongNumber];
                break;
        }
        return searchAmmunition;
    }
}
