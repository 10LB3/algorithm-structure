package com.ym.line.algo.sort;

import java.util.Arrays;

public class SelectionSorter extends Sorter{
    public void sort(int[] data){
        if(data == null || data.length <= 1) return;
        // 控制选择排序的轮数
        for (int i = 0; i < data.length; i++) {
            // 找到[i,n)中最小元素的索引
            int minNumIndex = i;
            for (int j = i + 1; j <data.length; j++) {
                if(data[j] < data[minNumIndex]){
                    minNumIndex = j;
                }
            }
            // 将data[i]和最小元素交换
            swap(data, i , minNumIndex);
        }
    }
    public static void main(String[] args) {
        int[] data = new int[]{10, 20, 3, 5, 7};
        System.out.println(data);
        System.out.println("==========");
        new SelectionSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
