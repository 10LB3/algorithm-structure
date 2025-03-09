package com.ym.line.queue;

public interface Queue<E> {
    /**
     * 查看队列有多少元素
     * @return 返回元素值
     */
    int getSize();

    /**
     * 判断队列元素是否是空
     * @return 返回true或false
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e 入队的元素
     */
    void enqueue(E e);

    /**
     * 出队的元素值
     * @return 出队的那一个元素值
     */
    E dequeue();

    /**
     * 查询队首的元素
     * @return 返回队首元素值
     */
    E getFront();
}
