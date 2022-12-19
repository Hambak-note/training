package com.example.design_pattern._01_creational_patterns._01_singleton;

public class RuntimeExample {

    public static void main(String[] args) {

        //new 로 생성 불가능
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.freeMemory());
    }
}
