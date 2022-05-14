package com.spaceshipdealership.model.Spaceship.Military.Carrier;

import com.spaceshipdealership.model.Spaceship.Military.Military;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Carrier extends Military {
    int spaceMarinesCapacity;
    int spaceCraftCapacity;

    public Carrier(String modelName, int price, PropulsionTypeEnum propulsionType, int enginePowerOutput, int shieldCapacity, int spaceMarinesCapacity, int spaceCraftCapacity) {
        super(modelName, price, propulsionType, enginePowerOutput, shieldCapacity);
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
                ", shieldCapacity=" + shieldCapacity +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", propulsionType=" + propulsionType +
                ", enginePowerOutput=" + enginePowerOutput +
                '}';
    }

    public String objectToCSV() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.getModelName(), this.getPrice(), this.getPropulsionType(), this.getEnginePowerOutput(), this.getShieldCapacity(), this.getSpaceMarinesCapacity(), this.getSpaceCraftCapacity());
    }
}
