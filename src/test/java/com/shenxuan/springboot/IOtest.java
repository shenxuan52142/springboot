package com.shenxuan.springboot;

import com.shenxuan.springboot.Enum.SpaceShip;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOtest {
    @Test
    public void test1(){
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add(0, "0");
        System.out.println(stringList);
    }
}
