package com.zhuyx.day1;

import com.zhuyx.utils.Generator;
import com.zhuyx.utils.SortUtils;

/**
 * 查询有序数组中小于num最大的数的下标
 */
public class BSNearRight {
    public static int existNearRight(int[] arr, int num) {
        int index = -1;
        if (arr == null || arr.length == 0) {
            return index;
        }
        int m;
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (arr[m] < num) {
                index = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] intArray = Generator.getIntArray(50, 30, true);
        int num = 20;
        int index = existNearRight(intArray, num);
        if (index == -1) {
            System.out.println("less than " + num + " is not exist in arr");
        } else {
            System.out.println("less than " + num + " is " + intArray[index]+"index:"+index);
        }
        SortUtils.printArr(intArray);
    }
}
