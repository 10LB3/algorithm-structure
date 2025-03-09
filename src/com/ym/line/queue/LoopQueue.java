package com.ym.line.queue;

public class LoopQueue<E> implements Queue<E>{
    private E[] data;
    private int head;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        head = tail = 0;
        size = 0;
    }

    /**
     * 获取数组容量
     * @return 返回当前容量
     */
    public int getCapacity(){
        return data.length - 1;
    }
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }
    // 时间复杂度O(1)
    @Override
    public void enqueue(E e) {
        // 判断队列是否存贮满了
        if((tail + 1) % data.length == head){
            // 队列已经满了
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;
    }

    // 时间复杂度O(1)
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i = 0; i < size; i++){
            newData[i] = data[(i + head) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new RuntimeException("dequeue error, there is empty");
        }
        E e = data[head];
        data[head] = null;
        size--;
        head = (head + 1) % data.length;
        if(size == getCapacity() / 4){
            resize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        return data[head];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array:size = %d, capacity = %d,\t", size, getCapacity()));
        sb.append("队首:[");
        for (int i = head; i != tail ; i = (i + 1)% data.length) {
            sb.append(data[i]);
            if((i + 1)% data.length != tail
            ){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
