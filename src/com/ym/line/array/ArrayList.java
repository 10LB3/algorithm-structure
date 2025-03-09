package com.ym.line.array;

/**
 * 动态数组:二次封装数组的增查改删(CRUD)
 * @param <E>
 */
// 空间复杂度O(1)
public class ArrayList<E> {
    private E[] data;
    private int capacity;
    private int size;

    /**
     * 有参构造方法
     * @param capacity 数组容量
     */
    public ArrayList(int capacity){
        this.data = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * 无参构造方法
     */
    public ArrayList(){
        this(15);
    }
    /****判空的方法****/
    public boolean isEmpty(){
        return size == 0;
    }
    /****获取真实数组长度****/
    public int getSize(){
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
    /****新增****/
//    时间复杂度:O(n)
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("index error, need valid index");
        }
        // 数组扩容
        if(size == data.length){
        // 1.创建一个容量为之前两倍的临时数组
            resize(capacity * 2);
        }
        for(int i = size - 1;i >= index;i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }
    //    时间复杂度:O(n)
    public void addFirst(E e){
        add(0, e);
    }
    //    时间复杂度:O(1)
    public void addLast(E e){
        add(size, e);
    }
    /****查询操作****/
    //    时间复杂度:O(1)
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("查询操作存在错误,index有误");
        }
        return data[index];
    }
    /****返回最后一个元素的值****/
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 得到第一个元素值
     * @return 出队的元素值
     */
    public E getFirst(){
        return get(0);
    }

    /****contains方法，是否包含****/
    //    时间复杂度:O(n)
    public boolean contains(E target){
        for(E num:data){
            if(num.equals(target)){
                return true;
            }
        }
        return false;
    }
    /****查询指定的索引****/
    //    时间复杂度:O(n)
    public int find(E e){
        for(int i = 0;i < size;i++){
            if(data[i] == e){
                return i;
            }
        }
        return -1;
    }
    /****修改操作****/
    //    时间复杂度:O(1)
    public void set(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("查询操作存在错误,index有误");
        }
        data[index] = e;
    }
    /****删除操作****/
    //    时间复杂度:O(n)
    public E remove(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("查询操作存在错误,index有误");
        }
        E res = data[index];
        for(int i = index + 1; i < size;i++){
            data[i - 1] = data[i];
        }
        size--;
        // 清除不用的对象
        data[size] = null;
        // 缩容操作 && data.length / 2 != 0
        if(size == getCapacity() / 4 ){
            resize( getCapacity() / 2);
        }
        return res;
    }
    //    时间复杂度:O(n)
    public E removeFirst(){
        return remove(0);
    }
    //    时间复杂度:O(1)
    public E removeLast(){
        return remove(size - 1);
    }
    /****删除指定的元素****/
    //    时间复杂度:O(n)
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }
    /****抽取一个扩容和缩容的方法****/
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array:size = %d, capacity = %d,\t", size, getCapacity()));
        sb.append("[");
        for(int i = 0;i<size;i++){
            sb.append(data[i]);
            if(i != size - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
