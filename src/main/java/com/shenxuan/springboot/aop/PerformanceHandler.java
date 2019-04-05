package com.shenxuan.springboot.aop;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {
    private Object target;
    //targer为业务类，被代理的对象
    public PerformanceHandler(Object target){
        this.target = target;
    }
    //proxy为最终生成 的代理实例，一般不会用到，
    // method是被代理目标实例的某个具体方法，通过它可以发起目标实例的反射调用
    //args是被代理实例某个方法的入参，在方法反射调用时使用
    public Object invoke(Object proxy, Method method, Object [] args)
                   throws Throwable{
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        //通过反射方法调用业务类的目标方法
        System.out.println("通过反射方法调用业务类的目标方法");
        Object obj = method.invoke(target, args);
        System.out.println("结束调用");
        PerformanceMonitor.end();
        return obj;
    }
}
