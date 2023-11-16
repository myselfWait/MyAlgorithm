package com.zhuyx.day04;

import com.zhuyx.utils.Generator;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        process(arr, 0, arr.length - 1);

    }

    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr,l,mid);
        process(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l + 1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while(p1 <= mid && p2 <= r){
            help[i++] = (arr[p1] <= arr[p2]) ? arr[p1++] : arr[p2++];
        }
        while(p2 <= r){
                help[i++] = arr[p2++];
        }
        while (p1 <= mid){
                help[i++] = arr[p1++];
        }
        for (int j = 0; j < r-l+1; j++) {
            arr[l+j] = help[j];
        }
        return;
    }


    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int mergeSize = 1;
        int n = arr.length;
        while(mergeSize < n){
            int l = 0;
            while(l < n){
                if(mergeSize > n-l){
                    break;
                }
                int m = l + mergeSize-1;
                int r = m + Math.min(mergeSize,n-m-1);
                merge(arr,l,m,r);
                l=r+1;
            }
            if(mergeSize> n/2){
                break;
            }
            mergeSize <<=1;
        }


    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            extracted();
        }
    }

    private static void extracted() {
        int[] intArray = Generator.getIntArray(20, 40, false);
        int[] deepClone = Generator.deepClone(intArray);
        mergeSort(intArray);
        mergeSort1(deepClone);
        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i] != deepClone[i]){
                System.out.println("出错了");
            }
        }
        System.out.println("完全正确");
    }
}
