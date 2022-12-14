package me.flower.java8to11.functional_interface_lambda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        Function<Integer, String> intToString = (i) -> "number";

        UnaryOperator<String> hi = (s) -> "hi " + s;
        //메소드 레퍼런스
        //스태틱 메소드 참조 - 타입::스태틱 메소드
        UnaryOperator<String> hi2 = Greeting::hi;

        //특정 객체의 인스턴스 메소드 참조 - 객체 레퍼런스::인스턴스 메소드
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("Flower"));

        //생성자 참조 - 타입::new
        //디폴트 생성자 사용
        Supplier<Greeting> newGreeting= Greeting::new;
        Greeting greeting1 = newGreeting.get();
        //파라미터가 있는 생성자
        Function<String, Greeting> flowerGreeting
                = Greeting::new;
        Greeting greeting2 = flowerGreeting.apply("Flower");

        //임의 객체의 인스턴스 메소드 참조 - 타입::인스턴스 메소드
        String[] names = {"Hambak", "Flower","Young"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));


    }
}
