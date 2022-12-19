package com.example.design_pattern._01_creational_patterns._01_singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Settings1 settings1 = Settings1.getInstance();
        System.out.println(settings1 == Settings1.getInstance());


        //싱글톤 패턴을 깨는 방법 1 - 리플랙션 사용하기
        Settings5 settings5 = Settings5.getInstance();


        Constructor<Settings5> constructor = Settings5.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Settings5 settings5_reflection = constructor.newInstance();

        System.out.println(settings5 == settings5_reflection);

        //싱글톤 패턴 깨는 방법 2 - 직렬화 & 역직렬화
        Settings5 settings5_serializable = null;

        //객체가 파일에 써지게 한다.
        try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))){
            out.writeObject(settings5);
        }
        //읽어온다.
        try(ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))){
            settings5_serializable = (Settings5) in.readObject();
        }

        System.out.println(settings5 == settings5_serializable);  //false


        Settings6 settings6 = Settings6.INSTANCE;

    }
}
