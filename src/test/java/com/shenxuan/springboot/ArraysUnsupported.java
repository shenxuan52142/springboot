package com.shenxuan.springboot;

import com.shenxuan.springboot.collection.map.AssociativeArray;
import com.shenxuan.springboot.collection.map.SimpleHashMap;
import com.shenxuan.springboot.collection.map.SlowMap;
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
    @Test
    public void test2(){
        SlowMap<String,String> slowMap=new SlowMap<String, String>();
        slowMap.put("1", "A");
        slowMap.put("2", "B");
        slowMap.put("3","C");
        slowMap.put("4", "D");
        System.out.println(slowMap.get("3"));
    }
    @Test
    public void test3(){
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");
        map.put("2", "@B");
        map.get("3");
    }
    @Test
    public void test4(){
        String var1 = new String("hello").intern();
        String[] strings="hello hello".split(" ");
        System.out.println(strings[0].hashCode());
        System.out.println(strings[1].hashCode());
        System.out.println(strings[0]==strings[1]);

        System.out.println(var1.hashCode());
        System.out.println(var1==strings[1]);
        System.out.println(var1==strings[0]);
    }
}
