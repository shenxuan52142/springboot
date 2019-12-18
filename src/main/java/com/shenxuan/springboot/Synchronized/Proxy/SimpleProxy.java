package com.shenxuan.springboot.Synchronized.Proxy;

public class SimpleProxy implements Interface {
    private Interface proxied;
    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy something");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse "+arg);
        proxied.somethingElse(arg);
    }
}
