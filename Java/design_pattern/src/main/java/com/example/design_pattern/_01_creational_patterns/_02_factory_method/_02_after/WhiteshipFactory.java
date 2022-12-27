package com.example.design_pattern._01_creational_patterns._02_factory_method._02_after;

import com.example.design_pattern._01_creational_patterns._03_abstract_factory._02_after.WhiteshipPartsFactory;

public class WhiteshipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new Whiteship();
    }
}
