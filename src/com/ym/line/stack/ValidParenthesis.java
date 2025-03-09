package com.ym.line.stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {

    }
    public boolean isValid(String s){
        if(s == null) return true;
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c == '('|| c == '{'||c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topElement = stack.pop();
                char matched = '#';
                if(c == ')'){
                    matched = '(';
                } else if (c == ']') {
                    matched = '[';
                }else {
                    matched = '{';
                }
                if (matched != topElement){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
