package codemanipulation.thejava.reflection;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {
        //Class 타입의 인스턴스를 가져오는 방법
        //1. 타입을 사용해서
        Class<Book> bookClass = Book.class;

        //2. 인스턴스를 사용해서
        Book book = new Book();
        Class<? extends Book> bookClass1 = book.getClass();

        //3. 파일명을 사용해서
        Class<?> bookClass2 = Class.forName("codemanipulation.thejava.reflection.Book");


        //출력 결과 정의된 필드 중 d만 나옴
        //getFields()는 public한 것만 가져온다
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        //다 가져 오려면 아래를 사용
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        //필드에서 값을 가져오는 법
        //값을 가져오려면 인스턴스가 존재해야 한다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try{
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        });


        //메서드 가져오기
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        //생성자 가져오기
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        //부모 클래스 가져오기
        System.out.println(MyBook.class.getSuperclass());

        //인터페이스 가져오기
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        //modifier
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });


        //애노테이션 사용
        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);

        //자식 까지 애노테이션 조회
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);




    }
}
