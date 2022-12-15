package me.flower.java8to11.chang_of_interface.defalt_static_method;

public interface Foo {
    void printName();
    String getName();

    /**
     * 인터페이스에 기능을 추가하면 이를 구현한
     * 모든클래스에수정 발생
     */
    //void printNameUpperCase();

    //디폴트 메서드를 사용해 위 문제를 해결
    /*
    * @implSpec
    * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

    //Object가 제공하는 기능은 불가
    //default String toString(){ }

    static void printAnything(){
        System.out.println("Foo");
    }

}
