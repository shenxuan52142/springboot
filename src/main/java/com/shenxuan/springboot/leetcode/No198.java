package com.shenxuan.springboot.leetcode;

public class No198 {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i:nums){
            int d = b;
            b = Math.max(a + i, b);
            a = d;
        }
        return b;
    }
}
