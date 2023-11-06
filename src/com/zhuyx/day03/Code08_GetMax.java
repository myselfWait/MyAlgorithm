package com.zhuyx.day03;

import com.zhuyx.utils.Generator;
import com.zhuyx.utils.SortUtils;

public class Code08_GetMax {
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    /**
     * 在数组arr上l到r下标上的最大值
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int process(int[] arr, int l, int r) {
        if(arr[l] == arr[r]){
            return arr[l];
        }
        int mid = l +((r-l)>>1);
        int lMax = process(arr,l,mid);
        int rMax = process(arr,mid+1,r);
        return Math.max(lMax,rMax);
    }

    public static void main(String[] args) {
        int[] intArray = Generator.getIntArray(10, 30, false);
        int max = getMax(intArray);
        SortUtils.printArr(intArray);
        System.out.println(max);
    }
}
