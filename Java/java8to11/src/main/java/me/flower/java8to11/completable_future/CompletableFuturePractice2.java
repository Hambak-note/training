package me.flower.java8to11.completable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFuturePractice2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        //hello가 끝난 다음에 world를 하겠다는 상황에서
        //원래는 아래와 같이 get해서 기다린 후 world를 get
        hello.get();
        world.get();

        //새로운 방식 - futurer 간에 연관관계가 있는 경우
        CompletableFuture<String> hello2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello2 " + Thread.currentThread().getName());
            return "Hello2";
        });

        CompletableFuture<String> future = hello2.thenCompose(CompletableFuturePractice2::getWorld2);
        System.out.println(future.get());

        //새로운 방식 - futurer 간에 연관관계가 없는 경우 - biFunction
        CompletableFuture<String> future1 = hello.thenCombine(world, (h, w) -> {
            return h + " " + w;
        });
        System.out.println(future1.get());

        //테스크가 2개 이상일 때 여러 테스크를 다 합쳐서 하는 방법
        //아래와 같이 작업하면 null 출력
        //어떤 특정한 결과를 가지고 올 수 없는 이유는
        //주어진 모든 테스크들의 결과가 동일한 타입이라는 보장도 없으며
        //그 중에 어떤 것은 에러가 났을 수도 있기 때문
        CompletableFuture<Void> future2 = CompletableFuture.allOf(hello, world)
                .thenAccept(System.out::println);
        System.out.println(future2.get());

        //null 값이 아니라 제대로 받으려면
        List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<String>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> {
                    return futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });

        results.get().forEach(System.out::println);

        //아무거나 하나 빨리 끝나는거 결과 받아서 하는 법
        CompletableFuture<Void> future5 = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
        future5.get();

        //예외처리 - exceptionally
        boolean throwError = true;
        CompletableFuture<String> hello3 = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });

        System.out.println(hello3.get());

        //예외처리 - handle
        CompletableFuture<String> hello4 = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if(ex != null){
                System.out.println(ex);
                return "ERROR!";
            }
            return result;
        });

        System.out.println(hello4.get());

    }

    private static CompletableFuture<String> getWorld2(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World2" + Thread.currentThread().getName());
            return message + " World2";
        });
    }
}
