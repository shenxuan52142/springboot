package com.shenxuan.springboot.Synchronized.ConnectionPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) {
        int threadcount = 10;
        end = new CountDownLatch(threadcount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadcount; i++) {
//            Thread thread=new Thread(new ConnetionRunner())
        }
    }

    static class ConnetionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnetionRunner(int count,AtomicInteger got,AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }
        @Override
        public void run() {
             try{
                 start.await();
             }catch (Exception ex){
                 //don't something
             }

        }
    }
}
