package com.shenxuan.springboot.Synchronized;

public class Haha extends Haha1 {

    public static String var1 = "sss";
    static {
        System.out.println("静态块");
        var1 = "ccccc";
        System.out.println(var1);
    }
    public Haha(){
        var1 = "bbbb";
        System.out.println("构造器");
    }
}
