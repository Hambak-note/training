package com.example.design_pattern._01_creational_patterns._02_factory_method._02_after;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.print(new WhiteshipFactory(), "whiteship", "white@gmail.com");
        client.print(new BlackshipFactory(), "Blackship", "black@gmail.com");



//        Ship whiteship = new WhiteshipFactory().orderShip("Whiteship", "white@gmail.com");
//        System.out.println(whiteship);
//
//        Ship blackship = new BlackshipFactory().orderShip("Blackship", "black@gmail.com");
//        System.out.println(blackship);

    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
