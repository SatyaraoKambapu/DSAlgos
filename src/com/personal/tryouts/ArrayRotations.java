package com.personal.tryouts;

public class ArrayRotations {

    public int[] arrayRotateByKElements(int[] arr, int k) {

        for(int i=0;i<k;i++) {
            leftRotateByOne(arr);
        }
        return arr;
    }

    private void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
    }

    private void printArray(int[] arr) {
        for (int i=0; i< arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    public static void main(String[] args) {
        ArrayRotations arrayRotations = new ArrayRotations();
        int[] result = new ArrayRotations().arrayRotateByKElements(new int[]{1,2,3,4,5,6,7}, 5);
        arrayRotations.printArray(result);
    }
}
