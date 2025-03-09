package com.ym.line.stack;

public interface Stack<E> {
    /**
     * 查看栈中有多少元素
     * @return 返回元素值
     */
    int getSize();

    /**
     * 判断栈中元素是否是空
     * @return 返回true或false
     */
    boolean isEmpty();

    /**
     * 压栈
     * @param e 将元素e压栈
     */
    void push(E e);

    /**
     * 出栈
     * @return 返回出栈的元素值
     */
    E pop();

    /**
     * 查看栈顶的元素
     * @return 返回栈顶的元素值
     */
    E peek();
}
