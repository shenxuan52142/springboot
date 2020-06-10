package com.shenxuan.springboot.leetcode;

public class No837 {
    public static double new21Game(int N, int K, int W) {
          if (K ==0){
              return 1.00;
          }
        double[] dp = new double[K + W+1];
        for (int i = K; i <K+W &&i<=N ; i++) {
            dp[i] = 1.00;
        }
        for (int i = K-1;i <K &&i>=0; i--) {
            if (i==K-1){
                double ii = 0.00;
                dp[i] = ii / (W);
                for (int j = 1; j <= W; j++) {
                    dp[i] += dp[i + j] / W;
                }
            }else {
                dp[i] = dp[i + 1] + ((dp[i + 1] - dp[i + W + 1]) / W);
            }
//            double ii = 0.00;
//            for (int j = i+1; j <=i+W ; j++) {
//                ii += dp[j];
//            }
//            dp[i] = ii / (W);
//            for (int j = 1; j <= W; j++) {
//                dp[i] += dp[i + j] / W;
//            }

        }
        return dp[0];
    }

    public static void main(String[] args) {
        new21Game(21, 17, 10);
    }
}
