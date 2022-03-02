package com.personal.tryouts;

/**
 * Use dynamic programming
 */
public class MaxSubArrayNonContiguous implements MaxSumSubArray{

    @Override
    public int getMaxSum(int[] a) {
        int n = a.length;
        int[] dp = new int[n];


        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return a[0];
        } else if(n == 2) {
            return Math.max(a[0], a[1]);
        } else if(n == 3){
            dp[0] = a[0];
            dp[1] = a[1];
            dp[2] = a[2] + a[0];
            return Math.max(dp[2], dp[1]);
        } else {
            dp[0] = a[0];
            dp[1] = a[1];
            dp[2] = a[2] + a[0];
            for(int i=3; i< n;i++) {
                dp[i] = a[i] + Math.max(dp[i-2], dp[i-3]);
            }
            return Math.max(dp[n-1], dp[n-2]);
        }
    }

    public static void main(String[] args) {

        MaxSubArrayNonContiguous maxSubArrayNonContiguous = new MaxSubArrayNonContiguous();
        int a[] = {5, 5, 10, 100, 10, 5};
        System.out.println(maxSubArrayNonContiguous.getMaxSum(a));

    }
}
