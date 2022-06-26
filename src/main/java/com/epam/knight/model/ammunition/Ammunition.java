package com.epam.knight.model.ammunition;

public interface Ammunition {

    int getWeight();

    int getCost();

    void setWeight(int weight);

    void setCost(int cost);

    int getValueProperty();

    void setItemProperty(int property);

    AmmunitionType getTypeAmmunition();
}
