package com.shenxuan.springboot.IO.File;

import java.io.File;
import java.util.Arrays;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
      
            list = path.list();

//        else {
//            list = path.list(new Dirfilter(args[0]));
//        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String dirItem:list){
            System.out.println(dirItem);
        }
    }
}
