package com.shenxuan.springboot.concurrency.ALL;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicityTest implements Runnable {
    private int i = 0;
//    private Lock lock = new ReentrantLock();
    public int getValue(){
        return i;
    }
    private   void evenIncrement(){
        i = i + 2;
        synchronized (this){

        }
//        System.out.println(i);
    }

    @Override
    public void run() {

        while (true){
            evenIncrement();
        }
    }

//    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        AtomicityTest at = new AtomicityTest();
//        exec.execute(at);
//
//        while (true){
//            int val = at.getValue();
////            System.out.println(val);
//            if (val % 2!=0){
//                System.out.println(val);
////                System.exit(0);
//            }
//        }
//    }
}
