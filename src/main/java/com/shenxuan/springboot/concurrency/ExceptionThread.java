package com.shenxuan.springboot.concurrency;

public class ExceptionThread implements Runnable{
    public void run(){
        throw new RuntimeException();
    }
}
