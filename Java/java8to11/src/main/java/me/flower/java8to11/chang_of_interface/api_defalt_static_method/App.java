package me.flower.java8to11.chang_of_interface.api_defalt_static_method;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class App {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("flower");
        name.add("cafe");
        name.add("book");
        name.add("title");

        name.forEach(System.out::println);
        System.out.println("=======================");

        Spliterator<String> spliterator = name.spliterator();
        //기존 spliterator 를 쪼갠다.
        Spliterator<String> spliterator1 = spliterator.trySplit();
        //다음 값이 없으면 false가 리턴됨
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("======================");
        while(spliterator1.tryAdvance(System.out::println));

        System.out.println("======================");
        long k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .count();
        System.out.println("k = " + k);

        name.removeIf(s -> s.startsWith("c"));
        name.forEach(System.out::println);

        System.out.println("======================");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());

    }
}
