package com.ym.line.queue;

import com.ym.line.array.ArrayList;

/**
 * 动态数组实现Queue
 */
public class ArrayQueue<E> implements Queue<E>{
    private ArrayList<E> data;
    public ArrayQueue(){
        data = new ArrayList<>();
    }

    /**
     * 队列大小
     * @return 数量
     */
    @Override
    public int getSize() {
        return data.getSize();
    }

    /**
     * 队列是否为空
     * @return 返回true或者false
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 入队选择在右边
     * @param e 入队的元素
     */
    // 时间复杂度O(1)
    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    /**
     * 出队
     * @return 返回出队的元素
     */
    // 时间复杂度O(n)
    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    /**
     * 得到队头元素
     * @return 第一个元素值
     */
    @Override
    public E getFront() {
        return data.getFirst();
    }

    /**
     * 改写字符串方法
     * @return 字符串类型
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("队头元素:");
        sb.append(data);
        sb.append(" 队尾元素");
        return sb.toString();
    }
}
