package com.spaceshipdealership.model.Spaceship.Military.Carrier;

import com.spaceshipdealership.model.Spaceship.Military.Military;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Carrier extends Military {
    int spaceMarinesCapacity;
    int spaceCraftCapacity;

    public Carrier(String modelName, int price, PropulsionTypeEnum populsionType, int shieldCapacity, int spaceMarinesCapacity, int spaceCraftCapacity) {
        super(modelName, price, populsionType, shieldCapacity);
        this.spaceMarinesCapacity = spaceMarinesCapacity;
        this.spaceCraftCapacity = spaceCraftCapacity;
    }

    public int getSpaceMarinesCapacity() {
        return spaceMarinesCapacity;
    }

    public void setSpaceMarinesCapacity(int spaceMarinesCapacity) {
        this.spaceMarinesCapacity = spaceMarinesCapacity;
    }

    public int getSpaceCraftCapacity() {
        return spaceCraftCapacity;
    }

    public void setSpaceCraftCapacity(int spaceCraftCapacity) {
        this.spaceCraftCapacity = spaceCraftCapacity;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "spaceMarinesCapacity=" + spaceMarinesCapacity +
                ", spaceCraftCapacity=" + spaceCraftCapacity +
                '}';
    }
}
