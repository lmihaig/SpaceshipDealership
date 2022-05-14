package com.spaceshipdealership.model.Spaceship.Civillian.Freighter;

import com.spaceshipdealership.model.Spaceship.Civillian.Civillian;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Freighter extends Civillian {
    int cargoCapacity;

    public Freighter(String modelName, int price, PropulsionTypeEnum propulsionType, int enginePowerOutput, int ftlSpeed, int cargoCapacity) {
        super(modelName, price, propulsionType, enginePowerOutput, ftlSpeed);
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
                ", ftlSpeed=" + ftlSpeed +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", propulsionType=" + propulsionType +
                ", enginePowerOutput=" + enginePowerOutput +
                '}';
    }

    public String objectToCSV() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getModelName(), this.getPrice(), this.getPropulsionType(), this.getEnginePowerOutput(), this.getFtlSpeed(), this.getCargoCapacity());
    }
}
