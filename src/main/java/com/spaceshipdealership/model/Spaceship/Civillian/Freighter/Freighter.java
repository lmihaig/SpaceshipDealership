package com.spaceshipdealership.model.Spaceship.Civillian.Freighter;

import com.spaceshipdealership.model.Spaceship.Civillian.Civillian;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Freighter extends Civillian {
    int cargoCapacity;

    public Freighter(String modelName, int price, PropulsionTypeEnum populsionType, int ftlSpeed, int cargoCapacity) {
        super(modelName, price, populsionType, ftlSpeed);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String toString() {
        return "Freighter{" +
                "cargoCapacity=" + cargoCapacity +
                '}';
    }
}
