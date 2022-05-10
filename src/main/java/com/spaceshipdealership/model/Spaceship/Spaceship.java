package com.spaceshipdealership.model.Spaceship;

import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public abstract class Spaceship {

    String modelName;
    int price;
    PropulsionTypeEnum populsionType;
    int enginePowerOutput;

    public Spaceship(String modelName, int price, PropulsionTypeEnum populsionType, int enginePowerOutput) {
        this.modelName = modelName;
        this.price = price;
        this.populsionType = populsionType;
        this.enginePowerOutput = enginePowerOutput;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PropulsionTypeEnum getPopulsionType() {
        return populsionType;
    }

    public void setPopulsionType(PropulsionTypeEnum populsionType) {
        this.populsionType = populsionType;
    }

    public int getEnginePowerOutput() {
        return enginePowerOutput;
    }

    public void setEnginePowerOutput(int enginePowerOutput) {
        this.enginePowerOutput = enginePowerOutput;
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "modelName='" + modelName + '\'' +
                ", price=" + price +
                ", populsionType=" + populsionType +
                ", enginePowerOutput=" + enginePowerOutput +
                '}';
    }
}
