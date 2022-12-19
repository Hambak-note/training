package com.example.design_pattern._01_creational_patterns._01_singleton;

public enum Settings6 {

    INSTANCE;

    Settings6() {

    }

    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
