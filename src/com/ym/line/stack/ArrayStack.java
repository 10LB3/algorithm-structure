package com.ym.line.stack;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E>{
    private E[] data;
    private int size;

    /**
     * 有参构造方法
     * @param capacity 传入数组容量
     */
    public ArrayStack(int capacity){
        data = (E[])new Object[capacity];
        this.size = 0;
    }

    /**
     * 栈的长度
     * @return 长度
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     *栈是否为空
     * @return true或者false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 压栈
     * @param e 将元素e压栈
     */
    @Override
    public void push(E e) {
        if(size == data.length){
            throw new RuntimeException("push failed, Stack is full");
        }
        data[size] = e;
        size++;
    }

    /**
     * 出栈
     * @return 出栈的元素值
     */
    @Override
    public E pop() {
        if(isEmpty()){
            throw new NoSuchElementException("pop failed, Stack is empty");
        }
        E e = data[size - 1];
        size--;
        return e;
    }

    /**
     * 查看栈顶元素
     * @return 栈顶元素值
     */
    @Override
    public E peek() {
        if(isEmpty()){
            throw new NoSuchElementException("peek failed, Stack is empty");
        }
        return data[size - 1];
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("Stack:[");
       for(int i = 0; i < size;i++){
           sb.append(data[i]);
           if(i != size - 1){
               sb.append(",");
           }
       }
       sb.append("] top");
       return sb.toString();
    }
}
