package com.ym.line.stack;

import java.util.Stack;

public class ArrayStackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new java.util.Stack<>();
        stack.push(5);
        System.out.println(stack);
        stack.push(29);
        System.out.println(stack);
        stack.push(30);
        System.out.println(stack);
        int re = stack.pop();
        System.out.println(re);
        System.out.println(stack);
    }
}
