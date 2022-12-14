package me.flower.java8to11.functional_interface_lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo2 {

    public static void main(String[] args) {
        //변수 캡쳐
        Foo2 foo2 = new Foo2();
        foo2.run();
    }

    private void run(){
        //함수 안에서 baseNumber 라는 로컬 변수를 참조 한다고 가정.
        int baseNumber = 10;
        //람다
        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);
        printInt.accept(10);

        //java 8 이전에는 baseNumber2 에 final 이 붙어 있어야만
        //익명 클래스 또는 내부 클래스에서 사용 가능 했다.
        final int baseNumber2 = 20;
        //로컬 클래스
        class LocalClass{
            void printBaseNumber2(){
                int baseNumber2 = 30;
                System.out.println(baseNumber2); //30
            }
        }

        //익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber2) {
                System.out.println(baseNumber2); //파라미터를 가리킨다.
            }
        };


    }
}
