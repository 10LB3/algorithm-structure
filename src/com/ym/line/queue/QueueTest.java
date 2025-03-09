package com.ym.line.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<>();
//        java.util.Queue
//        Deque<Integer> queue = new ArrayDeque<>();
        queue.enqueue(10);
        System.out.println(queue);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println(queue);
        int n = queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(n);
        System.out.println(queue);

    }
}
