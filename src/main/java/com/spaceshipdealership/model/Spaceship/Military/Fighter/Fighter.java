package com.spaceshipdealership.model.Spaceship.Military.Fighter;

import com.spaceshipdealership.model.Spaceship.Military.Military;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Fighter extends Military {
    int numGuns;

    public Fighter(String modelName, int price, PropulsionTypeEnum propulsionType, int enginePowerOutput, int shieldCapacity, int numGuns) {
        super(modelName, price, propulsionType, enginePowerOutput, shieldCapacity);
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
                ", shieldCapacity=" + shieldCapacity +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", propulsionType=" + propulsionType +
                ", enginePowerOutput=" + enginePowerOutput +
                '}';
    }

    public String objectToCSV() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getModelName(), this.getPrice(), this.getPropulsionType(), this.getEnginePowerOutput(), this.getShieldCapacity(), this.getNumGuns());
    }
}
