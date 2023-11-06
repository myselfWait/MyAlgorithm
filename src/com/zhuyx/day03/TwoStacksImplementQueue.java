package com.zhuyx.day03;

import java.util.Stack;

/**
 * 用两堆实现队列 push ,pop,每次操作，pop栈为空则将push栈的数据全部导入到poo
 */
public class TwoStacksImplementQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public void offer(Integer value) {
        pushStack.push(value);
        pushToPop();
    }

    public Integer poll(){
        if( popStack.isEmpty() && pushStack.isEmpty()){
            throw new RuntimeException("没有元素了");
        }
        pushToPop();
        Integer ans = popStack.pop();
        return ans;
    }

    public Integer peek(){
        if( popStack.isEmpty() && pushStack.isEmpty()){
            throw new RuntimeException("没有元素了");
        }
        pushToPop();
        Integer ans = popStack.peek();
        return ans;
    }

    private void pushToPop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }
}
