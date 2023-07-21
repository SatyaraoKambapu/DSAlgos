package com.personal.tryouts;

import java.util.Arrays;

public class ValidSale {

    public static void main(String[] args) {
        int[] denominations = {5,10,20,50}; // You can add your denominations here
        System.out.println(isValidSale(new int[]{5,5,5,5,10,10,10,10,5,50}, denominations));
    }

    public static boolean isValidSale(int[] arr, int[] denominations) {
        int count = 0;
        int moneyEarnedByMerchant = 0;
        for(int i=0; i<= arr.length-1; i++) {
            if(arr[i] < 5 || Arrays.binarySearch(denominations, arr[i]) == -1) {
                return false;
            } else if(moneyEarnedByMerchant >= (arr[i]-5)) {
                moneyEarnedByMerchant += 5;
                count++;
            }
        }
        if(count == arr.length) {
            return true;
        }
        return false;
    }
}
