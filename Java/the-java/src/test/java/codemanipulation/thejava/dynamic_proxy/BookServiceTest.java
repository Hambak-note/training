package codemanipulation.thejava.dynamic_proxy;

import net.bytebuddy.ByteBuddy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


class BookServiceTest {

    //원래 하던 일만 하는 프록시
    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new DefaultBookService();

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return method.invoke(bookService, args);
                }
            });

    //기능 추가 프록시
    BookService bookService2 = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new DefaultBookService();

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if(method.getName().equals("rent")){
                        System.out.println("AAAAA");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("vvvvv");
                        return invoke;
                    }
                    return method.invoke(bookService, args);
                }
            });

    @Test
    public void di(){
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService2.rent(book);
        bookService2.returnBook(book);
    }


    @Test
    public void di2(){

        MethodInterceptor handler = new MethodInterceptor() {
            BookService2 bookService2 = new BookService2();
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if(method.getName().equals("rent")){
                    System.out.println("aaaaa");
                    Object invoke = method.invoke(bookService2, args);
                    System.out.println("bbbbb");
                    return invoke;
                }
                return method.invoke(bookService2, args);
            }
        };

        BookService2 bookService = (BookService2) Enhancer.create(BookService2.class, handler);

    }



    @Test
    public void di3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<? extends BookService2> proxyClass = new ByteBuddy().subclass(BookService2.class)
                .make().load(BookService2.class.getClassLoader()).getLoaded();
        BookService2 bookService21 = proxyClass.getConstructor(null).newInstance();
    }

}