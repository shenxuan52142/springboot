package com.shenxuan.springboot.leetcode;

public class No121 {
    public int maxProfit(int[] prices) {
        int a = Integer.MAX_VALUE;
        int b = 0;
        for (int i = 0; i <prices.length ; i++) {
            if (prices[i]<a){
                a=prices[i];
            }else if (prices[i]-a>b){
                b = prices[i] - a;
            }
        }
        return b;
    }
}
