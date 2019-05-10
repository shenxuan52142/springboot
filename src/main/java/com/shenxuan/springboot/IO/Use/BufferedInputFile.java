package com.shenxuan.springboot.IO.Use;

import com.alibaba.fastjson.JSONObject;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BufferedInputFile {
      public static String read(String fileName)throws IOException{
          BufferedReader in = new BufferedReader(new FileReader(fileName));
          String s;
          StringBuffer sb = new StringBuffer();
          while ((s=in.readLine())!=null){
              sb.append(s + "\n");
          }
          in.close();
          return sb.toString();
      }

    public static void main(String[] args) throws IOException{
        String var1 = read("C:\\Users\\Administrator\\Desktop\\gupiao4.out");
        System.out.println(var1);
        List<String> list = new ArrayList<String>();
        int start = 0;
        int startFlag = 0;
        int endFlag = 0;
        for (int i = 0; i < var1.length(); i++) {
            if (var1.charAt(i) == '<') {
                startFlag++;
                if (startFlag == endFlag + 1) {
                    start = i;
                }
            } else if (var1.charAt(i) == '>') {
                endFlag++;
                if (endFlag == startFlag) {
                    list.add(var1.substring(start + 1, i));
                }
            }
        }
        System.out.println(list);
        String var2 = String.join(",",list);
        System.out.println(var2);
        List<String> list1 = Arrays.asList(var2.split(","));
        System.out.println(list1);
   TextFile.write("C:\\Users\\Administrator\\Desktop\\gupiao5.out",var2);
    }
}
