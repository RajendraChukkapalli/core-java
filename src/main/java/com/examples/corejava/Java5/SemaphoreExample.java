package com.examples.corejava.Java5;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Semaphore is kind of throttling mechanism.
 *
 * You can define the permits allowed against a Task and allow the threads to execute the
 * task in an orderly fashion. Once the permits are exhausted, other threads will wait for
 * the permit.
 *
 * Once the task is completed, then release the permit, which can be reused for other threads.
 *
 */
public class SemaphoreExample {

    static  Semaphore semaphore;

    public static void main( String[] args ) throws InterruptedException {

        semaphore  = new Semaphore(2);

        ExecutorService service = Executors.newFixedThreadPool(10);
        IntStream.of(1000).forEach(i -> service.execute(new RunnerTask()));

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);

    }

    static class RunnerTask implements Runnable {
        @Override
        public void run( ) {
                try {
                    semaphore.acquireUninterruptibly();
                    Thread.sleep(1000);
                    System.out.println("release thread...");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
