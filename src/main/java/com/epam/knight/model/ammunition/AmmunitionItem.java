package com.epam.knight.model.ammunition;

public class AmmunitionItem implements Ammunition {
    private AmmunitionType type;
    private int weight;
    private int cost;
    private int property;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getValueProperty() {
        return property;
    }

    public void setItemProperty(int property) {
        this.property = property;
    }

    public AmmunitionType getTypeAmmunition() {
        return type;
    }

    public void setType(AmmunitionType type) {
        this.type = type;
    }
}
