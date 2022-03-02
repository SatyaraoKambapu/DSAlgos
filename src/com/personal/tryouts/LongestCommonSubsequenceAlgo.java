package com.personal.tryouts;

/**
 * Used dynamic programming to solve this LCS problem.
 * O(mn);
 */
public class LongestCommonSubsequenceAlgo {

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int m = str1.length();
        int n = str2.length();

        int[][] lcs = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }

            }
        }
        System.out.println("LCS of both strings are = " + lcs[m][n]);
    }




}
