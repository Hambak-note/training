package com.example.design_pattern._01_creational_patterns._01_singleton;

import java.io.Serializable;

public class Settings5 implements Serializable{
    private Settings5() {}

    private static  class Settings5Holder  {
        private static final Settings5 INSTANCE = new Settings5();
    }

    public static Settings5 getInstance() {
        return Settings5Holder.INSTANCE;
    }

    //역직렬화 대응 방안
    //readResolve()라는 시그니처를 가지고 있으면
    //역직렬화를 할 때 반드시 사용하게 된다.
    //이 메소드 안에서 현재의 인스턴스를 반환하도록 변경해준다.,
    protected  Object readResolve(){
        return getInstance();
    }
}
