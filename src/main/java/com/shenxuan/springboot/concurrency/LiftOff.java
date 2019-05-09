package com.shenxuan.springboot.concurrency;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {

    }
    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") + "),";
    }
    @Override
    public void run() {
        try{
            while (countDown-- > 0){
                System.out.println(status());

                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (Exception e){
            System.out.println("222222");
        }

    }
}
