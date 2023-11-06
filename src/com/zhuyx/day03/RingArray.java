package com.zhuyx.day03;

/**
 * 用圆形数组实现一个队列
 */
public class RingArray {
    private int limit;
    private int size;
    private int start;
    private int end;
    private int[] arr;
    public RingArray(int limit){
        this.limit = limit;
        size = 0;
        start = 0;
        end = 0;
        arr = new int[limit];
    }

    public void push(int value) throws Exception {
        if(limit == size){
            throw new Exception("队列已经满了");
        }
        arr[end] = value;
        end = next(end);
        size++;
    }

    public int pop() throws Exception {
        if(size == 0){
            throw new Exception("队列为空");
        }
        size --;
        int ans = arr[start];
        start = next(start);
        return ans;
    }
    public boolean isEmpty() {
        return size == 0;
    }


    private int next(int end) {
        return end < end -1 ?end++:0;
    }
}
