package com.shenxuan.springboot;

import com.shenxuan.springboot.Enum.SpaceShip;
import com.shenxuan.springboot.IO.Use.TextFile;
import com.shenxuan.springboot.Synchronized.Haha;
import com.shenxuan.springboot.bean.Beans;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.shenxuan.springboot.IO.Use.BufferedInputFile.read;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOtest {
    @Test
    public void test1()throws Exception{
//        Haha haha = new Haha();
        System.out.println(Haha.var1);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        for (String s : stringStringHashMap.keySet()) {
            
        }

    }
}
