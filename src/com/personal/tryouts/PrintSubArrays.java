package com.personal.tryouts;

public class PrintSubArrays {

    public static void main(String[] args) {
        int a[] = {1,2,3};

        printSubArrays(a, 0, 0);
    }

    /**
     * recursive approach
     * @param a
     * @param start
     * @param end
     */
    static void printSubArrays(int[] a, int start, int end) {

        if(a.length == end) {
            return;
        } else if (start > end) {
            printSubArrays(a, 0, end+1);
        } else {
            System.out.print("[");
            for(int i=start; i<end; i++) {
                System.out.print(a[i]+ ",");
            }
            System.out.println(a[end] + "]");
            printSubArrays(a, start+1, end);
        }
        return;
    }
}
