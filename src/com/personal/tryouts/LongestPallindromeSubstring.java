package com.personal.tryouts;

import java.util.HashMap;
import java.util.Map;

public class LongestPallindromeSubstring {

    public static void main(String[] args) {
        String s = "Geeks";
        int n = s.length();
        int maxlen = 0;
        Map<Integer, String> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                String temp = s.substring(i,j);
                String reverse = new StringBuilder(temp).reverse().toString();
                if(temp.length() >= 2 && temp.equalsIgnoreCase(reverse)) {
                    if(maxlen< temp.length()) {
                        maxlen = temp.length();
                        map.put(maxlen, temp);
                    }
                }
            }
        }
        System.out.println("Longest palindrome substring is = " + map.get(maxlen));
    }
}
