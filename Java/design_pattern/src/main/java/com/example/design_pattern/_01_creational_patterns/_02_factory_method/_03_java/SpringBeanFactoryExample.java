package com.example.design_pattern._01_creational_patterns._02_factory_method._03_java;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactoryExample {

    public static void main(String[] args) {

        /**
         * BeanFactory가 Factory method 패턴을 구현한 구현체
         * <<interface>> Creator : BeanFactory
         * ConcreteCreator : ClassPathXmlApplicationContext, AnnotationConfigApplicationContext...
         * <<interface>> Product : Object
         * ConcreteProduct : 작성한 Bean / config.class, config.xml 등
         */

        BeanFactory xmlFactory = new ClassPathXmlApplicationContext("config.xml");
        String hello = xmlFactory.getBean("hello", String.class);
        System.out.println(hello);

        BeanFactory javaFactory = new AnnotationConfigApplicationContext(Config.class);
        String hi = javaFactory.getBean("hello", String.class);
        System.out.println(hi);
    }
}
