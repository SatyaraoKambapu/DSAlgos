package com.personal.tryouts;

/**
 * Find largest sum of contiguous sub array
 */
public class KadaneAlgo implements MaxSumSubArray {
    public static void main(String[] args) {
        KadaneAlgo kadaneAlgo = new KadaneAlgo();
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(kadaneAlgo.getMaxSum(a));
    }


    @Override
    public int getMaxSum(int[] a) {
        int n = a.length;

        int max_so_far = Integer.MIN_VALUE;
        int max_end_here = 0;

        for(int i=0; i < n; i++) {
            max_end_here += a[i];
            if(max_so_far <  max_end_here)
                max_so_far = max_end_here;

            if(max_end_here < 0)
                max_end_here = 0;

        }
        return max_so_far;
    }
}
