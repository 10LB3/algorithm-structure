package com.ym.line.linkedlist;

import java.util.NoSuchElementException;

/**
 * 双向链表:增查改删（CRUD)
 * @param <E> 泛型(引用数据类型）
 */
public class DoubleLinkedList<E> {
    /**
     * 双向链表中的节点，存在前后指针
     */
    private class Node {
        E e;
        Node next;
        Node prev;

        public Node(E e, Node next, Node prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }

        public Node(E e) {
            this(e, null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node first;
    private Node last;
    private int size;

    public DoubleLinkedList(){
        first = last = null;
        size = 0;
    }

    /**
     * 得到双向链表的大小
     * @return true或false
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断是否为空
     * @return true或false
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 根据指定的索引获取对象的元素值
     * @param index 元素的指定索引
     * @return 返回的是对应内容的值
     */
    // 时间复杂度O(n)
    public E get(int index){
        Node node = getNode(index);
        if(node == null){
            throw new IllegalArgumentException("get failed, index must > 0 and index < size");
        }
        return node.e;
    }
    // 获取第一个
    public Node getFirst(){
        return first;
    }
    // 获取最后一个
    public Node getLast(){
        return last;
    }

    /**
     * 根据下标得到当前节点值
     * @param index 下标
     * @return 节点
     */
    // 时间复杂度O(n)
    public Node getNode(int index){
        if(index < 0 || index >= size){
//            throw new IllegalArgumentException("get failed, index must > 0 and index < size");
            return null;
        }
        Node curr = null;
        if(index < size / 2){
            curr = first;
            for(int i = 0; i < index;i++){
                curr = curr.next;
            }
        }else{
            curr = last;
            for(int i = 0; i < size - index - 1;i++){
                curr = curr.prev;
            }
        }
        return curr;
    }

    /**
     * 根据下标和元素重新修改得到想要的
     * @param index 下标值
     * @param e 元素值
     */
    // 时间复杂度O(n)
    private void set(int index, E e){
        Node node = getNode(index);
        if(node == null){
            throw new IllegalArgumentException("get failed, index must > 0 and index < size");
        }
        node.e = e;
    }

    /**
     * 在双向链表的头节点插入元素
     * @param e 需要插入的元素值
     */
    // 时间复杂度O(1)
    public void addFirst(E e){
        Node newNode = new Node(e);
        if(first == null){
            last = newNode;
        }else{
            newNode.next = first;
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    /**
     * 在双向链表的尾部插入数据
     * @param e 需要插入的元素内容
     */
    // 时间复杂度O(1)
    public void addLast(E e){
        Node newNode = new Node(e);
        if(last == null){
            last = newNode;
        }else{
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        first = newNode;
        size++;
    }

    /**
     * 新增元素，包含所有情况
     * @param index 下标索引
     * @param e 元素的值
     */
    // 时间复杂度O(n)
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("get failed, index must > 0 and index < size");
        }
        if(index == size){
            addLast(e);
        }else if(index == 0){
            addFirst(e);
        }else{
           Node oldNode = getNode(index);
           Node prev = oldNode.prev;
           Node newNode = new Node(e,oldNode,prev);
           oldNode.prev = newNode;
           prev.next = oldNode;
           size++;
        }
    }

    /**
     * 删除第一个元素
     * @return 返回的是删除元素的值
     */
    // 时间复杂度O(1)
    public E removeFirstElement(){
        if (first == null){
            throw new NoSuchElementException();
        }
        E e = first.e;
        Node next = first.next;
        if(next == null){
            first = null;
            last = null;
        }else{
            first.next = null;
            next.prev =  null;
            first = next;
        }
        size--;
        return e;
    }

    /**
     * 删除最后一个元素的操作
     * @return 返回的是最后一个元素的值
     */
    // 时间复杂度O(1)
    public E removeLastElement(){
        if(last == null){
            throw new NoSuchElementException();
        }
        E e = last.e;
        Node prev = last.prev;
        if(prev == null){
            prev = null;
            last = null;
        }else{
            prev.next = null;
            last.prev = null;
            last = prev;
        }
        size--;
        return e;
    }

    /**
     * 删除整个元素
     * @param index 是索引值
     * @return 返回的是一个元素值
     */
    // 时间复杂度O(n)
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get failed, index must > 0 and index < size");
        }
        if(index == 0){
            return removeFirstElement();
        }else if(index == size - 1){
            return removeLastElement();
        }
        Node delNode = getNode(index);
        E e = delNode.e;
        Node prev = delNode.prev;
        Node next = delNode.next;
        // 将删除的节点与前后节点联系起来
        prev.next = next;
        next.prev = prev;
        // 将中间节点断开
        delNode.next = null;
        delNode.prev = null;
        size--;

        return e;
    }

}
