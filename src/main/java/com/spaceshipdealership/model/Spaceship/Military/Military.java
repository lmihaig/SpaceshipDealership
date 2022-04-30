package com.spaceshipdealership.model.Spaceship.Military;

import com.spaceshipdealership.model.Spaceship.Spaceship;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Military extends Spaceship {
    int shieldCapacity;

    public Military(String modelName, int price, PropulsionTypeEnum populsionType, int shieldCapacity) {
        super(modelName, price, populsionType);
        this.shieldCapacity = shieldCapacity;
    }

    public int getShieldCapacity() {
        return shieldCapacity;
    }

    public void setShieldCapacity(int shieldCapacity) {
        this.shieldCapacity = shieldCapacity;
    }

    @Override
    public String toString() {
        return "Military{" +
                "shieldCapacity=" + shieldCapacity +
                '}';
    }
}
