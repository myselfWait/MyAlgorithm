package com.zhuyx.day2;

import com.zhuyx.utils.Generator;
import com.zhuyx.utils.SortUtils;

public class EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
        short bin = -1;
        for (int i=0;i< 32 ;i++){
            bin = (short) ((arr[0]>>i) & 1);
            System.out.println(bin);
        }
    }

    public static void main(String[] args) {
        int[] intArray = {10,10,2,2,4,4,5};
        SortUtils.printArr(intArray);
        printOddTimesNum1(intArray);
    }


}
