package com.shenxuan.springboot.leetcode;

public class No509 {
    public int fib(int N) {
        int first = 0;
        int second = 1;
        if (N==0){
            return 0;
        }
        if (N==1){
            return 1;
        }
        for (int i = 2; i <N+1 ; i++) {
            int a = second;
            second = first + second;
            first = a;
        }
        return second;
    }
}
