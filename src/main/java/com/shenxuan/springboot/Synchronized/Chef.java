package com.shenxuan.springboot.Synchronized;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;
    private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };


    public Chef(Restaurant r) {
        restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                    if (++count==10) {
                        System.out.println("Out of food ,closing");
                        Thread thread = new Thread();

                        Thread.currentThread().isInterrupted();
                        restaurant.exec.shutdownNow();
                        restaurant.exec.shutdown();

                    }

                    System.out.println("Order up! ");
                    synchronized (restaurant.waitPerson) {

                        restaurant.meal = new Meal(restaurant.aa,count);
//                        value.set(value.get()+1);
                        restaurant.waitPerson.notifyAll();
                    }
                    TimeUnit.MILLISECONDS.sleep(100);

            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}
