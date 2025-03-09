package com.ym.line.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(5);
        System.out.println(linkedList);
        linkedList.add(1,34);
        System.out.println(linkedList);
        linkedList.addHead(87);
        System.out.println(linkedList);
        linkedList.get(1);
        System.out.println(linkedList.get(2));
        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);

    }
}
