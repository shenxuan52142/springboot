package com.shenxuan.springboot.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class No169 {
    public int majorityElement(int[] nums) {
        int ans=0;
        int count=1;
        for(int i:nums){
            if(i!=ans){
                count--;
                if(count==0){
                    ans=i;
                    count=1;
                }
            }else{
                count++;
            }
        }
        return ans;
    }

}
