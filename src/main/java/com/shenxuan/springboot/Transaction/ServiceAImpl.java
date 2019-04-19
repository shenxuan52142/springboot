package com.shenxuan.springboot.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ServiceAImpl implements ServiceA {

    @Autowired
    ServiceB serviceB;
    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public void test1() {
       try{
           String var1=serviceB.test2();
           System.out.println(var1);
       }catch (Exception e){
           System.out.println("sssssss");
       }

    }
}
