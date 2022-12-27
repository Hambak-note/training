package com.example.design_pattern._01_creational_patterns._03_abstract_factory._02_after;

//제품들을 만들어 준다.
public interface ShipPartsFactory {

    Anchor createAnchor();
    Wheel createWheel();
}
