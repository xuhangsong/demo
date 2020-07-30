package com.xhs.datasource.demo.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author xuhan  build  2019/5/24
 */
public class SynchronousQueneQuiz {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new SynchronousQueue<Integer>();
        new Thread(() ->{
              for(int i=0;i<100;i++){

                  System.out.println("放入"+i+queue.offer(i));
              }
        }).start();
        new Thread(() ->{
            try {
                for(int i=0;i<100;i++){
                    System.out.println(queue.take() + " ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(queue.size());
    }
}
