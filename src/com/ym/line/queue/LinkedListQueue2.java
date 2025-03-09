package com.ym.line.queue;

import com.ym.line.linkedlist.LinkedList;

/**
 * 改进:加上队尾指针+表尾作为队列的尾，性能最好
 * @param <E>
 */
public class LinkedListQueue2<E> implements Queue<E>{

    private class Node{
        E e;
        Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e, null);
        }
    }
    private Node head;
    private Node tail;
    private int size;
    // 自定义Node,不使用LinkedList里面封装的方法，没有队尾指针
    public LinkedListQueue2(){
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    // 时间复杂度 O(n)
    @Override
    public void enqueue(E e) {
        Node newNode = new Node(e);
        if(tail == null){
            tail = newNode;
            head = tail;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new RuntimeException("deque error, no element");
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new RuntimeException("getFront error, no element");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:队首[");
        Node curr = head;
        while (curr != null){
            sb.append(curr + "->");
            curr = curr.next;
        }
        sb.append("null ]");
        return sb.toString();
    }
}
