package com.zhuyx.day1;

import com.zhuyx.utils.Generator;
import com.zhuyx.utils.SortUtils;

/**
 * 在无序数组中找局部最小。cur=< cur-1  且cur>=cur+1
 */
public class BSAwesome {

    public static int existSAwesome(int[] arr) {
        int index = -1;
        int length = arr.length;
        if (arr == null || length <= 1) {
            return index;
        }
        if (arr[0] <= arr[1]) {
            return 0;
        }
        if (arr[length - 1] <= arr[length - 2]) {
            return length - 1;
        }
        int l = 0;
        int r = length - 1;
        int m;
        while (l < r) {
            m = l + ((r-l)>>1);
            if(arr[m] > arr[m-1] ){
                r = m-1;
            }else if(arr[m] > arr[m+1]){
                l = m + 1;
            }else {
                return m;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] array = Generator.getIntArray(10, 100, false);

//        int[] array = {79,29,73,45,39,31,2,75,41,76};

        int i = existSAwesome(array);
        if(i==-1){
            System.out.println("没有局部最小");
        } else {
            System.out.println("局部最小下标为:"+i +"值为"+array[i]);
        }
        SortUtils.printArr(array);
    }


}
