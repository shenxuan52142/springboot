package com.shenxuan.springboot.concurrency;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r){
        System.out.println(this+" creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler()
        );
        return t;
    }
}
