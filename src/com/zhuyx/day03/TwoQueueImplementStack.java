package com.zhuyx.day03;

import java.util.LinkedList;
import java.util.Queue;

/**
 *用两个队列实现栈：思路将两个队列相互倒数据，到最后一个元素后弹出，然后将 queue队列与help队列进行互换
 */
public class TwoQueueImplementStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueueImplementStack(){
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(Integer value){
        queue.offer(value);
    }

    public Integer pop(){
        if(queue.isEmpty()){
            throw new RuntimeException("已经空了");
        }
        while(queue.size() >1){
            help.offer(queue.poll());
        }
        Integer ans = queue.poll();
        Queue<Integer> temp = queue;
        queue = help;
        help = temp;
        return ans;
    }
}
