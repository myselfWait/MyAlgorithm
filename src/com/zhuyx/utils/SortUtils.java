package com.zhuyx.utils;

public class SortUtils {
    public static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void printArr(int[] arr) {
        if (arr == null || arr.length <= 1) {
            System.out.println("arr is null or less than 1");
            return;
        }
        System.out.print(arr[0] + ",");
        for (int i = 1; i < arr.length; i++) {
            if ((i+1) % 20 == 0) {
                System.out.println(arr[i] + ",");
            } else {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println();
    }
}
