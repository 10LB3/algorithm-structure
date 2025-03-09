package com.ym.line.stack;

import com.ym.line.linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E>{
    private LinkedList<E> linkedList;
    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addHead(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("链表实现栈:");
        sb.append(linkedList);
        return sb.toString();
    }
}
