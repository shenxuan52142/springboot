package com.shenxuan.springboot.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No136 {
//    public int singleNumber(int[] nums) {
//        HashMap<Integer,Integer> ss = new HashMap<>();
//        for (int i:nums){
//            if (ss.containsKey(i)){
//                ss.remove(i);
//            }else {
//                ss.put(i,i);
//            }
//
//        }
//        int re = 0;
//       for (Integer k:ss.keySet()){
//           re = k;
//       }
//        return re;
//    }
public int singleNumber(int[] nums) {
    int a = 0;
    for (int i = 0; i <nums.length ; i++) {
        if (i==0){
            a = nums[i];
        }else {
            a = a ^ nums[i];
        }
    }
    return a;
}
}
