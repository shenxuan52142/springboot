package com.shenxuan.springboot.leetcode;

import java.util.function.IntConsumer;

public class No1195 {
    private int n;

    public No1195(int n) {
        this.n = n;
    }

    volatile int a = 1;
    private Object lock = new Object();
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
           synchronized (lock){
               while (a<n){ lock.wait();

                   if (a%3==0){
                       printFizz.run();
                       a++;
                       lock.notifyAll();
                   }
                   lock.wait();
               }
           }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (lock){
          while (a<n){
              lock.wait();
              if (a<n){
                  if (a%5==0){
                      printBuzz.run();
                      a++;
                      lock.notifyAll();
                  }
                  lock.wait();
              }
          }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (lock) {
            while (a < n) {
                lock.wait();
                if (a < n) {
                    if (a % 3 == 0 && a % 5 == 0) {
                        printFizzBuzz.run();
                        a++;
                        lock.notifyAll();
                    } lock.wait();

                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock){
            while (a<n){
                if (a<n){
                    if (a%3!=0&&a%5!=0){
                        printNumber.accept(n);
                        a++;
                        lock.notifyAll();

                    }
                    lock.wait();
                }
            }

        }
    }
}
