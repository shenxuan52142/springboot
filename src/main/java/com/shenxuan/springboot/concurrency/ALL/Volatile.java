package com.shenxuan.springboot.concurrency.ALL;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Volatile {
    private volatile int a = 0;
    private  boolean canceled = false;

    public void cacel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public  void increment() {
        a = a + 2;
    }

    public int getA() {
        return a;
    }
}




