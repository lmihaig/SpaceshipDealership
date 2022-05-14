package com.spaceshipdealership.model.Spaceship.Civillian.Shuttle;

import com.spaceshipdealership.model.Spaceship.Civillian.Civillian;
import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public class Shuttle extends Civillian {
    int passengerCapacity;

    public Shuttle(String modelName, int price, PropulsionTypeEnum propulsionType, int enginePowerOutput, int ftlSpeed, int passengerCapacity) {
        super(modelName, price, propulsionType, enginePowerOutput, ftlSpeed);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String toString() {
        return "Shuttle{" +
                "passengerCapacity=" + passengerCapacity +
                ", ftlSpeed=" + ftlSpeed +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", propulsionType=" + propulsionType +
                ", enginePowerOutput=" + enginePowerOutput +
                '}';
    }

    public String objectToCSV() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getModelName(), this.getPrice(), this.getPropulsionType(), this.getEnginePowerOutput(), this.getFtlSpeed(), this.getPassengerCapacity());
    }
}
