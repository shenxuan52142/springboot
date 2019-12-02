package com.shenxuan.springboot.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        List<Integer> re = new ArrayList<>();
      while (b<nums.length&&c<nums.length){
          if (nums[b] != b+1&&nums[b]!=nums[nums[b]-1]) {
              a = nums[nums[b]-1];
                  nums[nums[b]-1] = nums[b];
                  nums[b] = a;


          }else {
              b++;
          }
      }
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=i+1){
                re.add(i + 1);
            }
        }
        return re;
    }
}
