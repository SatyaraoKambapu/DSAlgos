package com.personal.tryouts;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualToK {

    public static void main(String[] args) {
        int[] a = {-1,2,-3};

        int sum=0, count=0;
        int k=2;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0; i<a.length;i++) {
            sum += a[i];

            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum,0) +  1);
        }

        System.out.println("Sub array sum equal to K are " + count);
    }
}
