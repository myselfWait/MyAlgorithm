package com.zhuyx.day1;

import com.zhuyx.utils.Generator;
import com.zhuyx.utils.SortUtils;

import java.util.Arrays;

/**
 * 冒泡排序算法：数字像泡泡一样，最大的到冒到最上面
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length<=1){
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length ; j++) {
                if (arr[j] < arr[i]) {
                    SortUtils.swap(arr, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] intArray = Generator.getIntArray(100, 1000,false);
        SortUtils.printArr(intArray);
        int[] cloneArr = Generator.deepClone(intArray);
        bubbleSort(intArray);
        SortUtils.printArr(intArray);
        Arrays.sort(cloneArr);
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] != cloneArr[i]){
                System.out.println("Sort is error!");
            }
        }
        System.out.println("Sort is success!");
    }
}
