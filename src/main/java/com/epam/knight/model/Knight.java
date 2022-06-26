package com.epam.knight.model;

import com.epam.knight.model.ammunition.Ammunition;

import java.util.Arrays;

public class Knight {
    private static final int EMPTY_ARRAY = 0;
    private Ammunition[] ammunition = new Ammunition[EMPTY_ARRAY];
    private int cost;
    private int weight;
    private int damage;
    private int protection;

    public Ammunition[] getAmmunition() {
        return ammunition.clone();
    }

    public void setAmmunition(final Ammunition[] ammunition) {
        this.ammunition = ammunition.clone();
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getProtection() {
        return protection;
    }

    public int getDamage() {
        return damage;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public void equip(Ammunition element) {
        ammunition = Arrays.copyOf(ammunition,  ammunition.length + 1);
        ammunition[ammunition.length - 1] = element;
    }
}
