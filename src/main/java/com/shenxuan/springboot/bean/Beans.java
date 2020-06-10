package com.shenxuan.springboot.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    public static String var1 = "sss";
    static {
        i = 3;
        System.out.println("静态块");
    }

    static int i = 4;
   public Beans(){
       System.out.println("构造器");
    }
}
