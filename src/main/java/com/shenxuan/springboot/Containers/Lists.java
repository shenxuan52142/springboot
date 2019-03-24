package com.shenxuan.springboot.Containers;

import java.util.List;
import java.util.ListIterator;

public class Lists {
    private static boolean b;
    private static String s;
    private static int i;
    private static Iterable<String> it;
    private static ListIterator<String> list;
    public static void basicTest(List<String> a){
        a.add(1,"x");
        a.add("x");
        a.add("A B C D E F");
        a.add(3, "china");
//        b = a.containsAll("china");
        b = a.contains("1");
    }
}
