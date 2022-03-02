package com.personal.tryouts;

public class MoveZeros {

    public static void main(String[] args) {
        int a[] = {1,2,0,3,4,0,6,0,7}; // Move zeros to left

        moveZerosToLeft(a);
        System.out.println();
        moveZerosToRight(a);
    }

    private static void moveZerosToRight(int[] a) {
        if(a.length < 1) return;
        int readIndex = 0;
        int writeIndex = 0;

        while (readIndex < a.length) {
            if(a[readIndex] != 0) {
                a[writeIndex] = a[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        // for remaining elements
        while(writeIndex < a.length ) {
            a[writeIndex] = 0;
            writeIndex++;
        }

        for(int i = 0; i< a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }

    private static void moveZerosToLeft(int[] a) {
        if(a.length < 1) return;
        int readIndex = a.length-1;
        int writeIndex = a.length-1;

        while (readIndex >= 0) {
            if(a[readIndex] != 0) {
                a[writeIndex] = a[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        // for remaining elements
        while(writeIndex >= 0 ) {
            a[writeIndex] = 0;
            writeIndex--;
        }

        for(int i = 0; i< a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}
