package me.flower.java8to11.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("flower");
        names.add("cafe");
        names.add("book");
        names.add("title");

        //stream을 반환한다.
        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        //names에 저장된 값들은 바뀌지 않는데 그대로 소문자 출력
        names.forEach(System.out::println);

        //출력되지 않는다.
        names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        });

        System.out.println("================");
        /*
        * 중개형 오퍼레이터들은 터미널 오퍼레이터가 오기전까지 실행하지 않는다.
         */

        //터미널 오퍼레이터가 왔기 때문에 실행하고 출력된다.
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        List<String> collect1 = names.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        List<String> collect2 = names.parallelStream().map((s) -> {
                    System.out.println(s + " " + Thread.currentThread().getName());
                    return s.toUpperCase();
                }).collect(Collectors.toList());


    }
}
