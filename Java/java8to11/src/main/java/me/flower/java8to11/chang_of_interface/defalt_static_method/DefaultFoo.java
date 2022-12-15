package me.flower.java8to11.chang_of_interface.defalt_static_method;

public class DefaultFoo implements Foo, Bar {

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    //디폴트 메서드 재정의
    //Bar와 Foo에서 정의한 동일한 이름의 디폴트 메서드이기 때문에
    //재정의 해주지 않으면 컴파일 에러가 발생
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }
}
