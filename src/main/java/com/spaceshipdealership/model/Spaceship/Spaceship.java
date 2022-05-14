package com.spaceshipdealership.model.Spaceship;

import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public abstract class Spaceship {

    protected String modelName;
    protected int price;
    protected PropulsionTypeEnum propulsionType;
    protected int enginePowerOutput;

    public Spaceship(String modelName, int price, PropulsionTypeEnum propulsionType, int enginePowerOutput) {
        this.modelName = modelName;
        this.price = price;
        this.propulsionType = propulsionType;
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

    public PropulsionTypeEnum getPropulsionType() {
        return propulsionType;
    }

    public void setPropulsionType(PropulsionTypeEnum propulsionType) {
        this.propulsionType = propulsionType;
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
                ", propulsionType=" + propulsionType +
                ", enginePowerOutput=" + enginePowerOutput +
                '}';
    }
}
