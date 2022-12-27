package com.example.design_pattern._01_creational_patterns._03_abstract_factory._02_after;


import com.example.design_pattern._01_creational_patterns._02_factory_method._02_after.Ship;
import com.example.design_pattern._01_creational_patterns._02_factory_method._02_after.ShipFactory2;

public class ShipInventory {

    public static void main(String[] args) {
        ShipFactory2 shipFactory = new WhiteshipFactory(new WhitePartsProFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());
    }
}
