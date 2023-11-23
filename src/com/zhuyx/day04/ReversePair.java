package com.zhuyx.day04;

import com.zhuyx.utils.Generator;

import java.util.Arrays;

/**
 * 求一个数组中逆序对的个数
 * 逆序对，即排在前面但是数字比后面小
 */
public class ReversePair {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int length = (int) (Math.random() * 100) + 1;
            int max = (int) (Math.random() * 100) + 1;
            int[] arr = Generator.getIntArray(length, max, false);
            int[] ints = Generator.deepClone(arr);
            int result1 = reversePair(arr);
            int result2 = reversePair_Naive(ints);
            if (result1 != result2) {
                System.out.println("求小和错误");
                return;
            }
        }
        System.out.println("正确");
    }
    public static int reversePair(int[] arr){
        int result = process(arr, 0, arr.length - 1);
        return result;
    }
    public static int reversePair_Naive(int[] arr){
        if(arr == null || arr.length <= 1){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    result++;
                }
            }
        }
        return result;
    }

    private static int process(int[] arr, int l, int r) {
        if( l == r){
            return 0;
        }
        int mid = l + ((r-l)>>1);
        int lResult = process(arr,l,mid);
        int rResult = process(arr,mid+1,r);
        int mergResult = merge(arr,l,mid,r);
        return lResult+rResult+mergResult;
    }
    //
    private static int merge(int[] arr, int l, int mid, int r) {
        int p1 = mid;
        int p2 = r;
        int length = r-l+1;
        int[] temp = new int[length];
        int i = length-1;
        int result = 0;
        while(p1>=l && p2>mid){
            result += arr[p1] > arr[p2] ? p2-mid :0;
            temp[i--] = arr[p1] > arr[p2] ? arr[p1--] :arr[p2--];
        }
        while( p1 >= l){
            temp[i--] = arr[p1--];
        }
        while(p2 >mid){
            temp[i--] = arr[p2--];
        }
        for (int j = 0; j < length; j++) {
            arr[l + j] = temp[j];
        }
        return result;
    }

}

