package me.flower.java8to11.functional_interface_lambda;


@FunctionalInterface
public interface RunSomething {

    void doIt();

    static void printName(){
        System.out.println("Flower");
    }

    default  void printAge(){
        System.out.println("age");
    }
}
