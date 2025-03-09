package com.ym.line.algo.sort;

public class QuickSorter {
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
        // TODO
        return 0;
    }
}
