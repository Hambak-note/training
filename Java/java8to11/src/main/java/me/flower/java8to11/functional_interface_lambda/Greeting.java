package me.flower.java8to11.functional_interface_lambda;

public class Greeting {

    private String name;

    public Greeting(){

    }

    public Greeting(String name){
        this.name = name;
    }

    public String hello(String name){
        return "hello " + name;
    }

    public static String hi(String name){
        return "hi " + name;
    }

}
