package me.flower.java8to11.etc.annotation_change;

import java.util.Arrays;
import java.util.List;

@Chicken("양념")
@Chicken("마늘간장")
public class AnnotationChange {


    public static void main(String[] args){
        Chicken[] chickens = AnnotationChange.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });

        ChickenContainer chickenContainer = AnnotationChange.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });

    }

}
