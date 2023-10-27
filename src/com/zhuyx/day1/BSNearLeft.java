package com.zhuyx.day1;

import com.zhuyx.utils.Generator;
import com.zhuyx.utils.SortUtils;

/**
 *  找到最左的元素
 */
public class BSNearLeft {

    public static int existNearLeft(int[] arr,int num){
        int index = -1;
        if(arr ==null || arr.length ==0){
            return index;
        }
        int l = 0;
        int r = arr.length-1;

        int m = 0;
        while(l<=r){
            m=l + (r-l)/2;
            if(arr[m]>num){
                index = m;
                r = m -1;
            }else {
                l = m +1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] intArray = Generator.getIntArray(10, 6,true);
        int i = existNearLeft(intArray, 5);
        System.out.println("最左数为："+intArray[i]+",下标："+i);
        SortUtils.printArr(intArray);
    }

}
