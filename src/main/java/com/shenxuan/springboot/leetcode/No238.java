package com.shenxuan.springboot.leetcode;

public class No238 {
    public static int[] productExceptSelf(int[] nums) {
        int[] l = new int[nums.length];
        l[0] = 1;
        int[] r = new int[nums.length];
        r[nums.length - 1]=1;
        if (nums.length==1){
            return l;
        }
        for (int i = 1; i <nums.length ; i++) {
            l[i] = l[i - 1] * nums[i - 1];
        }
        for (int i = nums.length-2; i >=0 ; i--) {
            r[i] = r[i + 1] * nums[i + 1];
        }
        int[] re = new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {

            re[i] = l[i] * r[i];
        }
        return re;
    }

    public static void main(String[] args) {
        String ss = "今天天气很好AA";
        for (int i = 0; i <ss.length() ; i++) {
            System.out.println(ss.charAt(i));
        }
    }
}
