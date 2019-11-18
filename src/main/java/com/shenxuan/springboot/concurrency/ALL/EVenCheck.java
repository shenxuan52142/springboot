package com.shenxuan.springboot.concurrency.ALL;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EVenCheck implements Runnable{
    private Volatile aVolatile;
    private final int id;
    public EVenCheck(Volatile g,int ideent){
        aVolatile = g;
        id = ideent;
    }
    @Override
    public void run() {

       aVolatile.increment();
//        System.out.println(val);


    }


    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Volatile v = new Volatile();
        for (int i = 0; i <10000 ; i++) {
            exec.execute(new EVenCheck(v,i));
        }

      exec.shutdown();
        System.out.println(v.getA());
    }
}
