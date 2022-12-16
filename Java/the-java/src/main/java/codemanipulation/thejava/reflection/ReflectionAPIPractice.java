package codemanipulation.thejava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionAPIPractice {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> bookClass = Class.forName("codemanipulation.thejava.reflection.Book2");
        //기본 생성자 사용
        Constructor<?> constructor = bookClass.getConstructor(null);
        Book2 book = (Book2) constructor.newInstance();
        System.out.println(book);

        //파라미터가 있는 생성자 사용
        Constructor<?> constructor1 = bookClass.getConstructor(String.class);
        Book2 myBook = (Book2) constructor1.newInstance("myBook");
        System.out.println(myBook);

        //필드 사용
        Field a = Book2.class.getDeclaredField("A");
        //특정한 인스턴스의 필드면 값을 넘겨주지만
        //현재 위에서 지정한 A라는 필드는 static 필드이기 때문에 null을 넘겨준다
        System.out.println(a.get(null));
        //값을 세팅할 때는 set()을 사용
        //static 필드이기 때문에 오브젝트 자리에는 null을 주고 값을 입력
        a.set(null, "AAAAAA");
        System.out.println(a.get(null));

        //static이 아닌 특정한 인스턴스에 해당하는 필드
        Field b = Book2.class.getDeclaredField("B");
        //B는 private 이기 때문에
        b.setAccessible(true);
        System.out.println(b.get(book));
        b.set(book, "BBBBB");
        System.out.println(b.get(book));


        //메소드
        //getDeclaredMethod를 사용해야 private까지 가져옴
        Method c = Book2.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);

        Method d = Book2.class.getDeclaredMethod("d");
        d.invoke(book);

        //매개변수가 있는 경우
        Method sum = Book2.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(book, 10, 20);
        System.out.println(invoke);


    }
}
