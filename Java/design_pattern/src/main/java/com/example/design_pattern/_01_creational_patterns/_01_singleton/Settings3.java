package com.example.design_pattern._01_creational_patterns._01_singleton;

public class Settings3 {

    private static final Settings3 INSTANCE = new Settings3();

    private Settings3(){}

    public static synchronized Settings3 getInstance() {
        return INSTANCE;
    }

}
