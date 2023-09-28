package com.zhuyx.sort;

import com.zhuyx.utils.Generator;

import java.util.Arrays;

public class InsertSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length && j >= 1; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = Generator.getIntArray(100, 100);
        int[] cloneArr = Generator.deepClone(arr);
        sort(arr);
        Arrays.sort(cloneArr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != cloneArr[i]) {
                System.out.println("第" + i + "位，排序有误");
            }
        }
        System.out.println("排序正确");
    }
}
