package com.spaceshipdealership.model.Spaceship.Military.Fighter;

import com.spaceshipdealership.model.Spaceship.Military.Military;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Fighter extends Military {
    int numGuns;

    public Fighter(String modelName, int price, PropulsionTypeEnum populsionType, int enginePowerOutput, int shieldCapacity, int numGuns) {
        super(modelName, price, populsionType, enginePowerOutput, shieldCapacity);
        this.numGuns = numGuns;
    }

    public int getNumGuns() {
        return numGuns;
    }

    public void setNumGuns(int numGuns) {
        this.numGuns = numGuns;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "numGuns=" + numGuns +
                '}';
    }
}
