package com.shenxuan.springboot.leetcode;

public class No70 {
    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        for (int i = 3; i <n+1 ; i++) {
            int a = second;
            second = first + second;
            first = a;
        }
        return second;
    }

}
