package com.ym.line.queue;

import com.ym.line.linkedlist.LinkedList;

public class LinkedListQueue<E> implements Queue<E>{
    private LinkedList<E> data;
    public LinkedListQueue(){
        data = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
    // 时间复杂度 O(n)
    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("链表头:");
        sb.append(data);
        sb.append("链表尾");
        return sb.toString();
    }
}
