package com.shenxuan.springboot;

import com.shenxuan.springboot.Enum.SpaceShip;
import com.shenxuan.springboot.IO.Use.TextFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.shenxuan.springboot.IO.Use.BufferedInputFile.read;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOtest {
    @Test
    public void test1()throws Exception{
        String var1 = read("C:\\Users\\Administrator\\Desktop\\gupiao4.out");
        List<String> list1 = Arrays.asList(var1.split(","));
        List<String> list2 = new ArrayList<>();
        for(String s:list1){
            if (s.length()>5){
                String c=s.substring(31,s.length()-2);
                System.out.println(c);
                list2.add(c);
            }
        }

       String aa= String.join(",", list2);
        TextFile.write("C:\\Users\\Administrator\\Desktop\\gupiao6.out",aa);
    }
}
