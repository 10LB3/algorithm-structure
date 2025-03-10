package com.ym.line.algo.sort;

import java.util.Arrays;

public class ThreeWayQuickSorter extends Sorter{
    public class PartitionSegment{
        public int less;
        public int great;

        public PartitionSegment(int less, int great) {
            this.less = less;
            this.great = great;
        }
    }
    public void quickSort(int[] data){
        if(data == null || data.length <= 1) return;
        sort(data, 0 , data.length - 1);
    }
    private void sort(int[] data, int low, int high){
        if(low >= high) return;
        PartitionSegment partitionSegment = partition(data, low, high);
        sort(data, low, partitionSegment.less - 1);
        sort(data, partitionSegment.great + 1, high);
    }
    private PartitionSegment partition(int[] data, int low, int high) {
        int pivot = data[high];
        int less = low;
        int great = high;
        int i = low;
        while (i <= great){
            if(data[i] < pivot){
                swap(data, i, less);
                less++;
                i++;
            } else if (data[i] > pivot) {
                swap(data, i, great);
                great--;
            }else{
                i++;
            }
        }
        return new PartitionSegment(less,great);
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,3,4,3,6,89,34,67,23,56,7,9,0,231,9,5};
//        new ShellSorter().shellSorter(data);
        new ThreeWayQuickSorter().quickSort(data);
        System.out.println(Arrays.toString(data));
    }
}
