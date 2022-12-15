package me.flower.java8to11.completable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(3000L);
            return "Hello";
        };
//
//        Future<String> helloFuture = executorService.submit(hello);
//        //상태 체크
//        System.out.println(helloFuture.isDone());
//        System.out.println("Started!");
//
//        //get 을 만나는 순간 결과 값을 가져올 때 까지 기다린다. 블로킹 콜
//        helloFuture.get();
//
//        System.out.println(helloFuture.isDone());
//        System.out.println("End!");
//        executorService.shutdown();
//
        Future<String> helloFuture = executorService.submit(hello);
        //상태 체크
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        //false는 기다림, 기다린다 한들 일단 cancel을 호출하면 값을 가져올 수 없음
        //get 해서 가져올 수 없다는 말임
        helloFuture.cancel(true);

        System.out.println(helloFuture.isDone());
        System.out.println("End!");


        //여러 작업 동시에
        Callable<String> java = () -> {
            Thread.sleep(2000L);
            return "Java";
        };

        Callable<String> spring = () -> {
            Thread.sleep(1000L);
            return "Spring";
        };

        //invokeAll 은 전부 끝날 때까지 기다림
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, spring));
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        //invokeAny
        String s = executorService.invokeAny(Arrays.asList(hello, java, spring));
        System.out.println(s);

        executorService.shutdown();

    }
}
