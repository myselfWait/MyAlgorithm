package com.zhuyx.utils;

import java.util.Arrays;

public class Generator {

    public static int[] getIntArray(int lenth,int max,boolean ordered){

        if ( lenth< 1 || max < 0) {
            return null;
        }
        int[] arr = new int[lenth];
        for (int i = 0; i < lenth; i++) {
            arr[i] = (int) (Math.random()*max) +1;
        }
        if(ordered){
            Arrays.sort(arr);
        }
        return arr;
    }

    public static int[] deepClone(int[] arr) {
        int[] cloneArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            cloneArr[i] = arr[i];
        }
        return cloneArr;
    }
}
