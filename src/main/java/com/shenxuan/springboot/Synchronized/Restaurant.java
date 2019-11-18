package com.shenxuan.springboot.Synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    int aa;
    //菜单
    Meal meal;
    //新建线程池
    ExecutorService exec = Executors.newCachedThreadPool();
    //服务员和厨师  把该餐馆放进去 让其为该餐馆服务
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);

    public Restaurant(int a) {
        aa = a;
        exec.execute(chef);

        exec.execute(waitPerson);


    }

    public static void main(String[] args) {
        new Restaurant(1);
    }
}
