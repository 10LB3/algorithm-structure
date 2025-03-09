package com.ym.line.stack;

import java.util.Stack;

public class MinStack_155 {

}

/**
 * 辅助栈实现
 */
class Stack1{
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Stack1(){
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }
    public void push(int x){
        dataStack.push(x);
        /****等于的时候也要入栈，否则会出现bug****/
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }
    public void pop(){
        int top = dataStack.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }
    }
    public int top(){
        return dataStack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}

/**
 * Node节点
 */
class Node{
    int val;
    int min;

    public Node(){

    }
    public Node(int val, int min){
        this.min = min;
        this.val = val;
    }
}

/**
 * 最小栈，里面存储一个的节点包含最小值和元素值
 */
class Stack2{
    private Stack<Node> dataStack;

    public Stack2(){
        dataStack = new Stack<>();
    }

    public void push(int x){
        Node node = new Node();
        node.val = x;
        int min = x;
        if(!dataStack.isEmpty() && dataStack.peek().min < x){
            min = dataStack.peek().min;
        }
        node.min = min;
        dataStack.push(node);
    }

    public void pop(){
        dataStack.pop();
    }

    public int top(){
        return dataStack.peek().val;
    }

    public int getMin(){
        return dataStack.peek().min;
    }
}

/**
 * 链表的节点
 */
class Node1{
    int val;
    int min;
    Node1 next;

    public Node1(){

    }
    public Node1(int val, int min){
        this.min = min;
        this.val = val;
    }
}

/**
 * 用链表来实现栈
 */
class Stack3{
    private Node1 dummyNode;

    public Stack3(){
        dummyNode = new Node1();
    }

    public void push(int x){
        int min = x;
        Node1 head = dummyNode.next;
        if(head != null && head.min < x){
            min = head.min;
        }
        Node1 node1 = new Node1(x, min);
        node1.next = dummyNode.next;
        dummyNode.next = node1;
    }

    public void pop(){
        Node1 head = dummyNode.next;
        if(head != null){
            dummyNode.next = head.next;
            head.next = null;
        }
    }

    public int top(){
        return dummyNode.next.val;
    }

    public int getMin(){
        return dummyNode.next.min;
    }
}

