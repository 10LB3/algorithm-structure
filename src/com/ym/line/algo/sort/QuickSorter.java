package com.ym.line.algo.sort;

import org.omg.CORBA.DATA_CONVERSION;

import java.util.Arrays;

public class QuickSorter extends Sorter{
    public void quickSort(int[] data){
        if(data == null || data.length <= 1) return;
        sort(data, 0 , data.length - 1);
    }
    // 子问题
    private void sort(int[] data, int low, int high){
        if(low <= high) return;
        // 分区
        int j = partition(data, low, high);
        sort(data, low, j - 1);
        sort(data, j + 1, high);
    }

    private int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int less = low;
        int great = low;
        for(;great <= high - 1;great++){
            if(data[great] < pivot){
               swap(data, less , great);
               less++;
            }
        }
        swap(data, less, high);
        return less;
    }
    public static void main(String[] args) {
        int[] data = new int[]{1,3,4,3,6,89,34,67,23,56,7,9,0,231,9,5};
//        new ShellSorter().shellSorter(data);
            new QuickSorter().quickSort(data);
        System.out.println(Arrays.toString(data));
    }
}
