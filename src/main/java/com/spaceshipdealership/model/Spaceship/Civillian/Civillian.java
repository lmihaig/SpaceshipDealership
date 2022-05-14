package com.spaceshipdealership.model.Spaceship.Civillian;

import com.spaceshipdealership.model.Spaceship.Spaceship;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Civillian extends Spaceship {
    protected int ftlSpeed;

    public Civillian(String modelName, int price, PropulsionTypeEnum propulsionType, int enginePowerOutput, int ftlSpeed) {
        super(modelName, price, propulsionType, enginePowerOutput);
        this.ftlSpeed = ftlSpeed;
    }

    public int getFtlSpeed() {
        return ftlSpeed;
    }

    public void setFtlSpeed(int ftlSpeed) {
        this.ftlSpeed = ftlSpeed;
    }

    @Override
    public String toString() {
        return "Civillian{" +
                "ftlSpeed=" + ftlSpeed +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", propulsionType=" + propulsionType +
                ", enginePowerOutput=" + enginePowerOutput +
                '}';
    }
}
