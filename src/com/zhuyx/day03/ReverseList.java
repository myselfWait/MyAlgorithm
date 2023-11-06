package com.zhuyx.day03;

public class ReverseList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int data){
            this.value = data;
        }
    }

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
    public DoubleNode generateRandomDoubleList(int len ,int value){
        int size = (int)(Math.random()*(len+1));
        if(size == 0){
            return null;
        }
        DoubleNode head = new DoubleNode((int)(Math.random()*(value+1)));
        DoubleNode pre = head ;
        while(size>0){
            DoubleNode cur = new DoubleNode((int)(Math.random()*(value+1)));
            pre.next = cur;
            cur.last = pre;
            pre = cur;
            size--;
        }
        return head;
    }
}
