package com.shenxuan.springboot;

import com.shenxuan.springboot.collection.map.AssociativeArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArraysUnsupported {

    @Test
    public void test1(){
        AssociativeArray<String,String> map=new AssociativeArray<String,String>(6);
        map.put("1","A");
        map.put("2","B");
        map.put("3","C");
        System.out.println(map.get("3"));
    }
}
