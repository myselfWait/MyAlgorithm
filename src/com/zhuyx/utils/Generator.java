package com.zhuyx.utils;

public class Generator {

    public static int[] getIntArray(int lenth,int max){
        if ( lenth< 1 || max < 0) {
            return null;
        }
        int[] arr = new int[lenth];
        for (int i = 0; i < lenth; i++) {
            arr[i] = (int) Math.random()*max +1;
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
