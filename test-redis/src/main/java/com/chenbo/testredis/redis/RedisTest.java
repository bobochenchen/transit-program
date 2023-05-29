package com.chenbo.testredis.redis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RedisTest {
    private static Integer inventory = 1001;
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(inventory,inventory,10L, SECONDS,linkedBlockingQueue);
        final CountDownLatch countDownLatch = new CountDownLatch(NUM);
        long start = System.currentTimeMillis();
        for (int i = 0; i <= NUM ; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    reentrantLock.lock();
//                    synchronized (o){
                        inventory--;
//                    }
                    reentrantLock.unlock();
//                    j--;
                    System.out.println("线程执行："+Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            });

        }
        threadPoolExecutor.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("执行线程数："+NUM+"   总耗时："+(end-start)+"   库存数为："+inventory);
    }
}
