package com.shenxuan.springboot.concurrency.ALL;

public class Accessor implements Runnable {
    private final int id;
    public Accessor(int idn){
        id = idn;
    }
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    public String toString(){
        return "#" + id + ": " +
                ThreadLocalVariableHolder.get();
    }
}
