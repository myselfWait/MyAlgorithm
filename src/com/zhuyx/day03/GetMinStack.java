package com.zhuyx.day03;

import java.util.Stack;

/**
 * 最小栈：
 * 用两个栈存数据，其中一个栈的栈顶维持此栈最小的元素
 */
public class GetMinStack {

    public static class MyStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MyStack() {
            dataStack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(Integer value) {
            dataStack.push(value);
            if (minStack.isEmpty() || value <= getMin()) {
                minStack.push(value);
            }
        }

        public Integer pop() {
            if (dataStack.isEmpty() || minStack.isEmpty()) {
                throw new RuntimeException("没有数据了");
            }
            Integer ans = dataStack.pop();
            if (minStack.peek().equals(ans)){
                minStack.pop();
            }
            return ans;
        }

        public Integer getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return minStack.peek();
        }

    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        int num = 10;
        int max = 100;
        for (int i = 0; i < num; i++) {
            myStack.push((int)(Math.random()*(max+1)));
        }
        System.out.println(myStack.getMin());

    }
}
