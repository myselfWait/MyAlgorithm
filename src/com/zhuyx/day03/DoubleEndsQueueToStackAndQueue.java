package com.zhuyx.day03;

public class DoubleEndsQueueToStackAndQueue {

    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            this.value = data;
        }
    }

    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T value) {
            Node<T> cur = new Node<T>(value);
            if (head == null){
                head = cur;
                tail = cur;
            } else {
               cur.next = head;
               head.last = cur;
               head = cur;
            }
        }

        public void addFromBottom(T value) {
            Node<T> cur = new Node<T>(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }
        public T popFromHead() {
            if(head == null){
                return null;
            }
            Node<T> cur = head;
            if(head == tail){
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }
        public T popFromBottom() {
            if(head == null){
                return null;
            }
            Node<T> cur = tail;
            if(head == tail){
                head = null;
                tail = null;
            } else {
                tail.last = tail;
                tail.next = null;
                cur.last = null;

            }
            return cur.value;
        }
    }


}
