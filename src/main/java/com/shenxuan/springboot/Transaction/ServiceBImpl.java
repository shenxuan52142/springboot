package com.shenxuan.springboot.Transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBImpl implements ServiceB {
    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public String test2() {
        int a = 1 / 0;
        return "ceshi";
    }
}
