package com.ym.line.stack;

import com.ym.line.array.ArrayList;

public class DynamicArrayStack<E> implements Stack<E>{
    private ArrayList<E> data;
    public DynamicArrayStack(int capacity){
        this.data = new ArrayList<>(capacity);
    }
    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DynamicStack:[");
        sb.append(data);
        sb.append("]");
        return sb.toString();
    }
}
