package com.shenxuan.springboot.Reflect;

import java.lang.reflect.Constructor;

public class ReflectTest {
    public static void main(String[] args) throws Throwable{
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.shenxuan.springboot.Reflect.Car");
        Constructor<Car>[] dd=clazz.getConstructors();
        for (Constructor constructor:dd){
            if (constructor.getParameterCount()>0){
                Class[] ss = constructor.getParameterTypes();
                for (Class c:ss){
                    System.out.println(c.getName());
                }
            }

        }
        System.out.println("sss");
    }
}
