package com.ym.line.algo.twoPoint;

public class ReverseString {
    public String reverseString(String s){
        char[] chars = s.toCharArray();
        if(s == null) return null;
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while(left <= right){
               char temp = chars[left];
               chars[left] = chars[right];
               chars[right] = temp;
               left++;
               right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(new ReverseString().reverseString(s));
    }
}
