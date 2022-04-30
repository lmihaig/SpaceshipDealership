package com.spaceshipdealership.model.Spaceship;

import com.spaceshipdealership.model.enums.PropulsionTypeEnum;

public abstract class Spaceship {

    String modelName;
    int price;
    PropulsionTypeEnum populsionType;

    public Spaceship(String modelName, int price, PropulsionTypeEnum populsionType) {
        this.modelName = modelName;
        this.price = price;
        this.populsionType = populsionType;
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

    @Override
    public String toString() {
        return "Spaceship{" +
                "modelName='" + modelName + '\'' +
                ", price=" + price +
                ", populsionType=" + populsionType +
                '}';
    }
}
