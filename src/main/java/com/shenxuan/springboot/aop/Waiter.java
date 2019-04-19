package com.shenxuan.springboot.aop;

public class Waiter {
    public void greeTo(String name){
        System.out.println("waiter greet to "+name+"....");
    }
    public void serveTo(String name){
        System.out.println("waiter serving "+name+"......");
    }
}
