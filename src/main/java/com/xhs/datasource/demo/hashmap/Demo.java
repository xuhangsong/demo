package com.xhs.datasource.demo.hashmap;


import java.util.concurrent.CountDownLatch;

/**
 * @author xuhan  build  2020/3/11
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        System.out.println("countDownLatch");
        for(int i=0;i<5;i++){
            new Thread(() -> {countDownLatch.countDown();
                System.out.println(Thread.currentThread());}).start();
        }
        System.out.println("线程已启动"+System.currentTimeMillis());
        countDownLatch.await();
        System.out.println("线程运行结束"+System.currentTimeMillis());
    }
}
