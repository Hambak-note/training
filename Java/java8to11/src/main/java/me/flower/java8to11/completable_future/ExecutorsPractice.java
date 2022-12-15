package me.flower.java8to11.completable_future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsPractice {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread : " + Thread.currentThread().getName());
            }
        });

        //실행을 하고 나서 다음 작업이 들어올 때까지 대기 한다
        //꺼지지 않음
        executorService.submit(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
        });
        //graceful shutdown
        executorService.shutdown();
        //not graceful shutdown
        executorService.shutdownNow();

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(getRunnable("Hello"));
        executorService1.submit(getRunnable("world"));
        executorService1.submit(getRunnable("The"));
        executorService1.submit(getRunnable("Java"));
        executorService1.submit(getRunnable("Thread"));

        executorService1.shutdown();

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //scheduledExecutorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);



    }

    private static Runnable getRunnable(String message) {
        return () ->System.out.println(message + Thread.currentThread().getName());
    }
}
