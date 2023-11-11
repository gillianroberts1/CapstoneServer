package com.capstone.capstone.enums;

public enum Area {
    SOUTH("Glasgow South"),
    NORTH("Glasgow North"),
    WEST("Glasgow West"),
    EAST("Glasgow East");

    private String name;

    Area(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
