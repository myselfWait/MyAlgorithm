package com.zhuyx.day04;

import com.zhuyx.utils.Generator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 小和，在一个数组中的，左边小于自己的数之和
 * 个数左边比它小的数的总和
 * 用归并排序的思想，看比自己右边小的数有多少，全部加起来
 */
public class SmallSum {

    public static void main(String[] args) throws InterruptedException, IOException {
        for (int i = 0; i < 10000; i++) {
            int lenght = (int) (Math.random() * 100) + 1;
            int max = (int) (Math.random() * 100) + 1;
            int[] arr = Generator.getIntArray(lenght, max, false);
            int[] ints = Generator.deepClone(arr);
            int result1 = smallSum(arr);
            int result2 = smallSum_Naive(ints);
            if (result1 != result2) {
                System.out.println("求小和错误");
                return;
            }
        }
        System.out.println("正确");
    }

    private static int smallSum(int[] arr) {
        int result = process(arr, 0, arr.length - 1);
        return result;
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        int lResult = process(arr, l, mid);
        int rResult = process(arr, mid + 1, r);
        int mergeResult = merge(arr, l, mid, r);
        return lResult + rResult + mergeResult;
    }

    private static int smallSum_Naive(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    result += arr[i];
                }
            }
        }
        return result;
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int p1 = l;
        int p2 = mid + 1;
        int[] tempArr = new int[r - l + 1];
        int i = 0;
        int result = 0;
        while (p1 <= mid && p2 <= r) {
            result += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            tempArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            tempArr[i++] = arr[p1++];
        }
        while (p2 <= r) {
            tempArr[i++] = arr[p2++];
        }
        for (int j = 0; j < r - l + 1; j++) {
            arr[l + j] = tempArr[j];
        }
        return result;
    }
}

