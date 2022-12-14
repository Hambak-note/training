package me.flower.java8to11.functional_interface_lambda;

import java.util.function.*;

public class Foo {

    public static void main(String[] args) {

        //익명 내부 클래스 anonymous inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello");
            }
        };
        
        //람다식 변환
        RunSomething runSomething2 = () -> System.out.println("Hello");
        runSomething2.doIt();


        RunSomething2 runSomething2_1 = (number) -> {
            return number+10;
        };

        //순수함수가 아니게 되는 경우 예시
        //1. 함수 밖에 있는 값을 참조해서 사용하는 경우
        RunSomething2 runSomething2_2 = new RunSomething2() {
            int baseNumber = 10;
            @Override
            public int doIt(int number) {
                return number+baseNumber;
            }
        };

        //2. 외부에 있는 값을 변경하려는 경우
        RunSomething2 runSomething2_3 = new RunSomething2() {
            int baseNumber = 10;
            @Override
            public int doIt(int number) {
                baseNumber++;
                return number + baseNumber;
            }
        };

        //Function 예제
        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        //람다로 바로 구현
        Function<Integer, Integer> plus20 = (i) -> {
            return i+20;
        };
        System.out.println(plus20.apply(1));

        Function<Integer, Integer> multiply2 = (i) -> i *2;
        System.out.println(multiply2.apply(1));

        //compose
        Function<Integer, Integer> multiply2AndPlus20 = plus20.compose(multiply2);
        System.out.println(multiply2AndPlus20.apply(2));

        //andThen
        Function<Integer, Integer> plus20AndMultiply2 = plus20.andThen(multiply2);
        System.out.println(plus20AndMultiply2.apply(2));

        //Consumer
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        //Supplier
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        //Predicate
        Predicate<String> startsWithFlower = (s) -> s.startsWith("Flower");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

        //UnaryOperator
        UnaryOperator<Integer> plus30 = (i) -> i+30;


    }

}
