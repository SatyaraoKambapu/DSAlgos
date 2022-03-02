package com.personal.tryouts;

public class PalindromeSubStrings {
    public static void main(String[] args) {
        String s = "aabbbaa";
        int n = s.length();
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
              String temp = s.substring(i,j);
              String reverse = new StringBuilder(temp).reverse().toString();
              if(temp.length() >= 2 && temp.equalsIgnoreCase(reverse)) {
                  System.out.println(temp);
                  count++;
              }
            }
        }
        System.out.println("Number of palindrome substrings are = " + count);
    }
}
