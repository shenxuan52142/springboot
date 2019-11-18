package com.shenxuan.springboot.concurrency.ALL;

import java.util.Random;

public class Count {
    public int id = 0;
    private int count = 0;
    public   int a = 0;
     public Count(int id){
         this.id = id;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    private Random rand = new Random(47);
    public synchronized int  increment(){
        int temp = count;
        if (rand.nextBoolean()){
            Thread.yield();
        }
        return (count = ++temp);
    }
}
