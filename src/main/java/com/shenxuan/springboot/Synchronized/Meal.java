package com.shenxuan.springboot.Synchronized;

public class Meal {
    private final int re;
    private final int orderNum;
    public Meal(int re,int orderNum){
        this.re = re;
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "我是餐馆 "+re +"号   Meal " + orderNum;
    }
}
