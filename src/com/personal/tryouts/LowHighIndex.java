package com.personal.tryouts;

/**
 * Use Binary search
 */
public class LowHighIndex {

    public static void main(String[] args) {
        int a[] = {1,2,2,3,3,4,4,4,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,8,8,8,8};
        int key = 5;

        findLowIndex(a, key); //8
        findHighIndex(a, key);//12

    }

    private static void findLowIndex(int[] a, int key) {
        int low=0;
        int high = a.length-1;
        int mid = a.length/2;

        while (low<= high) {
            int midElem = a[mid];
            // If key greater, ignore left half
            if(midElem < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = low + (high-low)/2;

        }
        if(low< a.length&& a[low] == key) {
            System.out.println("Low Index of " + key + " is " + low);
        } else {
            System.out.println("Low Index of " + key + " is " + -1);
        }
    }

    private static void findHighIndex(int[] a, int key) {
        int low=0;
        int high = a.length-1;
        int mid = a.length/2;

        while (low<= high) {
            int midElem = a[mid];
            // If key greaterThanOrEqual, ignore left half
            if(midElem <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            mid = low + (high-low)/2;

        }
        if(high< a.length&& a[high] == key) {
            System.out.println("High Index of " + key + " is " + high);
        } else {
            System.out.println("High Index of " + key + " is " + -1);
        }
    }
}
