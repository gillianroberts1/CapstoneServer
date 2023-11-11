package com.capstone.capstone.enums;

public enum GlasgowPark {

    KELVINGROVE("Kelvingrove", "easy", "Glasgow West"),
    BOTANIC("Botanic Gardens", "moderate", "Glasgow West"),
    RIVERVIEW("Riverview Park", "moderate", "Glasgow West"),
    HYNDFORD("Hyndford Glen Park", "easy", "Glasgow West"),

    QUEENS("Queens Park", "moderate", "Glasgow South"),
    POLLOK("Pollok Country Park", "moderate", "Glasgow South"),
    MAXWELL("Maxwell Park", "easy", "Glasgow South"),
    ROUGHOLM("Roughholm Park", "easy", "Glasgow South"),
    NEWLANDSK("Newlands Park", "moderate", "Glasgow South"),

    GLASGOWGREEN("Glasgow Green", "easy", "Glasgow East"),
    ALEXANDRA("Alexandra Park", "moderate", "Glasgow East"),
    VICTORIA("Victoria Park", "easy", "Glasgow East"),
    ROGARTSTREET("Rogart Street Park", "easy", "Glasgow East"),
    BARROWLAND("Barrowland Park", "moderate", "Glasgow East"),

    SPRINGBURN("Springburn Park", "easy", "Glasgow North"),
    RUCHILL("Ruchill Park", "moderate", "Glasgow North"),
    KELVINMEADOWS("Kelvin Meadows Park", "easy", "Glasgow North"),
    SUMMERSTON("Summerston Park", "moderate", "Glasgow North"),
    EGLINTONCOUNTRY("Eglinton Country Park", "easy", "Glasgow North");

    private String name;
    private String difficulty;
    private String area;

    GlasgowPark(String name, String difficulty, String area) {
        this.name = name;
        this.difficulty = difficulty;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
