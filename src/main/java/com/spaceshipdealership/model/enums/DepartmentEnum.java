package com.spaceshipdealership.model.enums;

public enum DepartmentEnum {
    SALES("S"),
    ACCOUNTING("F"),
    TECHNICIANS("T");

    private final String code;

    public String getCode() {
        return code;
    }

    DepartmentEnum(String code) {
        this.code = code;
    }
}
