package com.shenxuan.springboot.leetcode;

public class No796 {
    public boolean rotateString(String A, String B) {
       String c=A+A;
       if (A.length()!=B.length()){
           return false;
       }
       if (c.contains(B)){
           return true;
       }else {
           return false;
       }
    }
}
