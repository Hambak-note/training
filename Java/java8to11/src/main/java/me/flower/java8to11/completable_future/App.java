package me.flower.java8to11.completable_future;

public class App {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        //2번째 방법
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1: " + Thread.currentThread().getName());
            }
        });
        thread1.start();

        //2번째 방법 - 람다
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread2: " + Thread.currentThread().getName());
        });
        thread2.start();

        Thread thread3 = new Thread(() -> {
            try{
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread3: " + Thread.currentThread().getName());
        });
        thread3.start();
//
//        //인터럽트
//        Thread thread4 = new Thread(() -> {
//            while(true){
//                System.out.println("Thread4: " + Thread.currentThread().getName());
//                try{
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    System.out.println("exit!");
//                    return;
//                }
//            }
//        });
//        thread4.start();

        Thread thread5 = new Thread(() -> {
            System.out.println("Thread5: " + Thread.currentThread().getName());
            try{
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread5.start();


        System.out.println("Hello: " + Thread.currentThread().getName());
//        Thread.sleep(3000L);
//        thread4.interrupt();
        thread5.join();
        System.out.println(thread5 + " is finished");

    }

    //좀 불편한 방법 - 1번째 방법
    static class MyThread extends  Thread{
        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName());
        }
    }
}
