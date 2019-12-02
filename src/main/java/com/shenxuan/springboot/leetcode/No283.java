package com.shenxuan.springboot.leetcode;

public class No283 {
    public void moveZeroes(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=0){
                nums[a] = nums[i];
                if (a!=i){
                    nums[i] = 0;
                }
                a = a + 1;
            }
        }
    }
}
