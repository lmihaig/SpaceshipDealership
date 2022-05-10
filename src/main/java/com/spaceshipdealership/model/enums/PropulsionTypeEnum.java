package com.spaceshipdealership.model.enums;

public enum PropulsionTypeEnum {
    DILITHIUM(3),
    HYDROGEN(0.5),
    ION(1.3),
    DARK_MATTER(4.2);

    private final double efficiency;

    PropulsionTypeEnum(double efficiency) {
        this.efficiency = efficiency;
    }

    public double getEfficiency() {
        return efficiency;
    }
}
