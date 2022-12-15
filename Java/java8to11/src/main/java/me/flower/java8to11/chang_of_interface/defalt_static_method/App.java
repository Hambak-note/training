package me.flower.java8to11.chang_of_interface.defalt_static_method;

public class App {

    public static void main(String[] args) {
        Foo foo = new DefaultFoo("Flower");
        foo.printName();
        foo.printNameUpperCase();

        //인터페이스의 static 메서드 호출
        Foo.printAnything();
    }
}
