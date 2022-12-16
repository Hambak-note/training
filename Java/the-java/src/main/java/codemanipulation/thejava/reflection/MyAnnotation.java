package codemanipulation.thejava.reflection;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//타입과 필드에만 붙일 수 있게 지정
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface MyAnnotation {

    String value();
    String name() default "flower";
    int number() default 100;

}
