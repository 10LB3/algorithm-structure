package com.ym.line.algo.recursion;

public class Fibonacci {
    public int fibonacci(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int fib1 = fibonacci(n - 1);
        int fib2 = fibonacci(n - 2);
        return fib1 + fib2;
    }
}
