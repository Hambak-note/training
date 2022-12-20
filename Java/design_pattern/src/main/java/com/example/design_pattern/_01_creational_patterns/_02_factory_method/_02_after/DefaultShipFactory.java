package com.example.design_pattern._01_creational_patterns._02_factory_method._02_after;


/**
 * 인터페이스의 private 메소드는 자바 9버전부터 사용가능
 * 자바 11버전이라면 기존코드가 상관없지만
 * 자바 8버전을 사용했을 때 아래와 같이 추상 클래스를 따로 빼준다.
 * private 메서드로 작성되어 있던 것을 추상메서드로 변경하고
 * 이 추상 클래스에서 오버라이딩 해 준다.
 * 그리고 각 Factory 클래스들은 이 추상클래스를 상속 받는다.
 */
public abstract class DefaultShipFactory implements ShipFactory2{

    @Override
    public void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " 다 만들었습니다.");
    }
}
