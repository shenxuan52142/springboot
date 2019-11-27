package com.shenxuan.springboot.leetcode;

public class No1114 {
    public No1114() {

    }
//    volatile int a = 0;
//    public void first(Runnable printFirst) throws InterruptedException {
//         while (a!=0);
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        a = 1;
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        while (a != 1);
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        a = 2;
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//          while (a!=2);
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
    volatile int a = 0;
    private boolean first = false;
    private boolean second = false;
    private Object lock = new Object();
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock){
            printFirst.run();
            first = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock){
            while (!first){
                lock.wait();
            }
            printSecond.run();
            second = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock){
            while (!second){
                lock.wait();
            }
            printThird.run();
            second = true;
            lock.notifyAll();
        }
    }
}
