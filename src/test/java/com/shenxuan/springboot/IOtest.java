package com.shenxuan.springboot;

import com.shenxuan.springboot.Enum.SpaceShip;
import com.shenxuan.springboot.Transaction.ServiceA;
import com.shenxuan.springboot.aop.ForumService;
import com.shenxuan.springboot.aop.ForumServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOtest {
    @Autowired
    ServiceA serviceA;
    @Test
    public void test1(){
       serviceA.test1();

    }
}
