package com.example.design_pattern._01_creational_patterns._02_factory_method._02_after;

public class BlackshipFactory implements ShipFactory{
    @Override
    public Ship createShip() {
        return new Blackship();
    }
}
