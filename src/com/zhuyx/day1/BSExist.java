package com.zhuyx.day1;

import com.zhuyx.utils.Generator;
import com.zhuyx.utils.SortUtils;

import java.util.Arrays;

/**
 * 在有序数组中找一个数是否存在
 */
public class BSExist {
    public static boolean bSExist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0;
        int r = arr.length;
        int m = 0;
        while (l < r) {
            m = l + (r-l)/2;
            if (arr[m] == num) {
                return true;
            } else if (arr[m] < num) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return arr[l] == num;
    }


    public static void main(String[] args) {
        int[] intArray = Generator.getIntArray(100, 100,true);

        int num = 50;
        boolean exist = bSExist(intArray, num);
        if(exist){
            System.out.println(num+"is in arr");
        }
        SortUtils.printArr(intArray);
    }
}
