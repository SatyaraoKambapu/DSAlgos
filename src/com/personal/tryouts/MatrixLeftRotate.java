package com.personal.tryouts;

public class MatrixLeftRotate {


    public static void main(String[] args) {

        int[][] a = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        a = leftRotate(a);

        print(a);

    }

    private static void print(int[][] a) {
        for(int i = 0; i< a.length; i++) {
            for(int j = 0; j< a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Same solution can be used even if its rotate by 90 degree
     * @param a
     * @return
     */
    private static int[][] leftRotate(int[][] a) {
        int n = a.length;
        int mid = 0;
        if(n % 2 == 0)
            mid = (n/2) - 1;
        else
            mid = n/2;

        for(int i=0, j=n-1; i<= mid; i++,j--) {
            for(int k=0; k<j-i;k++) {
                a = swap(a, i,j-k, j, i+k); //( swap ru and ld)
                a = swap(a, i+k,i, j, i+k); //( swap lu and ld)
                a = swap(a, i,j-k, j-k, j); //( swap ru and rd)
            }
        }
        return a;
    }

    static int[][] swap(int[][] a, int x1, int x2, int y1, int y2) {
        int temp = a[x1][x2];
        a[x1][x2] = a[y1][y2];
        a[y1][y2] = temp;
        return a;
    }

}
