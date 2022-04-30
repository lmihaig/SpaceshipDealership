package com.spaceshipdealership.model.Spaceship.Civillian.Shuttle;

import com.spaceshipdealership.model.Spaceship.Civillian.Civillian;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Shuttle extends Civillian {
    int passangerCapacity;

    public Shuttle(String modelName, int price, PropulsionTypeEnum populsionType, int ftlSpeed, int passangerCapacity) {
        super(modelName, price, populsionType, ftlSpeed);
        this.passangerCapacity = passangerCapacity;
    }

    public int getPassangerCapacity() {
        return passangerCapacity;
    }

    public void setPassangerCapacity(int passangerCapacity) {
        this.passangerCapacity = passangerCapacity;
    }

    @Override
    public String toString() {
        return "Shuttle{" +
                "passangerCapacity=" + passangerCapacity +
                '}';
    }
}
