package com.examples.corejava.Java5;

import java.util.concurrent.*;

/**
 * Executor service can be used to create a thread pool. creating threads runtime is time consuming
 * and not efficient. Instead you can create a pool of threads and make them available.
 *
 * There are multiple thread pools you can use
 * 1. Fixed thread pool  - Linked Blocking queue
 * 2. schedule thread pool - Creates a thread pool that can schedule commands to run after a
 *    given delay, or to execute periodically.
 * 3. single thread pool. (only 1 thread is created)
 * 4. cached thread pool
 */
public class ExecutorServiceExample {
    public static void main( String[] args ) {

        System.out.println("Thread.currentThread().getName()=  "  + Thread.currentThread().getName());
        int coresCount = Runtime.getRuntime().availableProcessors();
        System.out.println("coresCount=" + coresCount);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        for (int i=0; i< 100; i++) {
            ScheduledFuture sFuture = executorService.scheduleAtFixedRate(new RunnableImpl(), 15, 10 , TimeUnit.SECONDS);
            if (sFuture.isDone()) {
                System.out.println("sFuture.isDone()");
            } else {
                System.out.println("sFuture.cancel()");
                sFuture.cancel(true);
            }
        }
        System.out.println("Thread.currentThread().getName()=  "  + Thread.currentThread().getName());
        System.exit(0);
    }
}


class RunnableImpl implements Runnable {
    @Override
    public void run( ) {
        System.out.println("Thread.currentThread().getName()=  "  + Thread.currentThread().getName());
    }
}