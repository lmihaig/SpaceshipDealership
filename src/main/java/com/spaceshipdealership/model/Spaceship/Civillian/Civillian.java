package com.spaceshipdealership.model.Spaceship.Civillian;

import com.spaceshipdealership.model.Spaceship.Spaceship;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Civillian extends Spaceship {
    int ftlSpeed;

    public Civillian(String modelName, int price, PropulsionTypeEnum populsionType, int enginePowerOutput, int ftlSpeed) {
        super(modelName, price, populsionType, enginePowerOutput);
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
                '}';
    }
}
