package com.zhuyx.day1;

public class MergeSort {

    public static void main(String[] args) {

    }
    private void process(int[] arr,int L,int R){
        if(L == R){
            return;
        }
        int mid = L + (R-L)>>1+1;
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);

    }

    private void merge(int[] arr, int L, int mid, int r) {
        int[] help = new int[10];
        
    }
}
