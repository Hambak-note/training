package me.flower.java8to11.chang_of_interface.defalt_static_method;

public interface Bar {

    //인터페이스 FOO와 동일한 이름의 디폴트 메서드
    default void printNameUpperCase(){
        System.out.println("BAR");
    }
}
