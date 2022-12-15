package me.flower.java8to11.completable_future;

import java.util.concurrent.*;

public class CompletableFuturePractice {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("flower");

        CompletableFuture<String> future1 = CompletableFuture.completedFuture("flower");
        System.out.println(future1.get());

        //리턴이 없는 경우
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
        });
        future2.get();

        //리턴 타입이 있는 경우
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(future3.get());

        //결과가 왔을 때 비동기적으로 콜백을 실행해줬으면 좋겠다 할때
        //future를 get 호출하기 전에 정의할 수 없었으나
        //thenApply를 통해서 가능하게 됨
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }).thenApply((s)-> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });

        System.out.println(future4.get());

        //콜백에 리턴 값이 없는 경우
        CompletableFuture<Void> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept((s) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });

        future5.get();

        //리턴을 받을 필요가 없다 뭔가 하기만 하면 된다.
        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        future6.get();


        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello" + Thread.currentThread().getName());
            return "Hello";
        }, executorService).thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        }, executorService);

        future7.get();


    }
}
