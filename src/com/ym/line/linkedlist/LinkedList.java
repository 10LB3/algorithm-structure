package com.ym.line.linkedlist;

/**
 * 动态单向链表:增查改删(CRUD)
 * @param <E> 泛型(引用数据类型)
 */
public class LinkedList<E> {
    /**
     * 链表中的Node节点
     */
    private class Node{
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    // 虚拟头结点
    private Node dummyHead;
    // 节点长度
    private int size;
    // 构造方法
    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }
    // 获得长度
    public int getSize() {
        return size;
    }
    // 是否存在元素
    public boolean isEmpty(){
        return  size == 0;
    }

    /**
     * 查询指定索引节点的值
     * @param index 索引下标
     * @return 返回的是节点的值
     */
    // 时间复杂度O(n)
    public E get(int index){
        // 检查index的合理性
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get failed, index must > 0 and index < size");
        }
        Node curr = dummyHead.next;
        for(int i = 0;i < index;i++){
            curr = curr.next;
        }
        return curr.e;
    }
    // 时间复杂度O(1)
    // 获得第一个
    public E getFirst(){
        return get(0);
    }
    // 时间复杂度O(n)
    // 获得最后一个
    public void getLast(){
        get(size - 1);
    }

    /**
     * 修改链表指定的索引值
     * @param index 指定的索引
     * @param e 需要修改的元素的值
     */
    // 时间复杂度O(n)
    public void set(int index,E e){
        // 检查index的合理性
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get failed, index must > 0 and index < size");
        }
        Node curr = dummyHead.next;
        for(int i = 0;i < index;i++){
            curr = curr.next;
        }
        curr.e = e;
    }

    /**
     * 在链表表头新增节点
     * @param e 新增的元素值
     */
    // 时间复杂度O(1)
    public void addHead(E e){
        //  方式一
//        Node newNode = new Node(e);
//        newNode.next = head;
//
//        head = newNode;
        //  方式二
//        head = new Node(e, head);
        add(0, e);
//        size++;
    }
    /**
     * 在链表的表尾进行插入元素
     * @param e 需要插入的元素
     */
    // 时间复杂度O(n)
    public void addLast(E e){
        add(size, e);
    }
    /**
     * 在链表中插入元素
     * @param index 插入位置的索引
     * @param  e 插入的元素值
     */
    // 时间复杂度O(n)
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("get failed, index must > 0 and index < size");
        }
        Node newNode = new Node(e);;
        Node prev = dummyHead;
        for(int i = 0;i < index;i++){
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }
    /**
     * 删除头结点
     * @return 返回删除元素的值
     */
    // 时间复杂度O(1)
    public E removeFirst(){
//        if(head == null) return null;
//        Node delNode = head;
//        head = head.next;
//        delNode.next = null;
//        return delNode.e;
       return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return 返回的是最后一个元素的值
     */
    // 时间复杂度O(n)
    public E removeLast(){
       return remove(size - 1);
    }
    /**
     * 删除链表中的元素
     * @param index 找到当前的索引
     * @return 返回的是被删除的元素
     */
    // 时间复杂度O(n)
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("get failed, index must > 0 and index < size");
        }
        Node prev = dummyHead;
        for(int i = 0;i < index;i++){
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 用来测试链表中是否包含某一个元素
     * @param e 想来测试的元素
     * @return 返回true或false,存在与不存在
     */
    // 时间复杂度O(n)
    public boolean contains(E e){
        Node curr = dummyHead.next;
        while(curr != null){
            if(curr.e.equals(e)){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = dummyHead.next;
        while(curr != null){
            sb.append(curr.e + "=>");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
