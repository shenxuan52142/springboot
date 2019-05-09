package com.shenxuan.springboot.aop;

public class WaiterDelegate {
    private Waiter waiter;
    public void service(String clientName){
        waiter.greeTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter){
        this.waiter = waiter;
    }
}
