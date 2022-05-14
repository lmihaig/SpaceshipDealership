package com.spaceshipdealership.model.enums;

public enum DepartmentEnum {
    SALES("S"),
    ACCOUNTING("A"),
    TECHNICIANS("T");

    private final String code;

    DepartmentEnum(String code) {
        this.code = code;
    }

    public static DepartmentEnum fromString(String text) {
        for (DepartmentEnum b : DepartmentEnum.values()) {
            if (b.code.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }
}
