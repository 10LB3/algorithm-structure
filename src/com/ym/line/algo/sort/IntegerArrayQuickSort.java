package com.ym.line.algo.sort;

import java.util.ArrayList;

public class IntegerArrayQuickSort extends Sorter{
    public void quickSort(ArrayList<Integer> data){
        if(data == null || data.size() <= 1) return;
        Integer[] dataArr = data.toArray(new Integer[data.size()]);
        sort(dataArr, 0 , dataArr.length - 1);

        data.clear();  //清空
        for (Integer i:dataArr) data.add(i); //排完序的再加入
    }
    // 子问题
    private void sort(Integer[] dataArr, int low, int high){
        if(low <= high) return;
        // 分区
        int j = partition(dataArr, low, high);
        sort(dataArr, low, j - 1);
        sort(dataArr, j + 1, high);
    }

    private int partition(Integer[] dataArr, int low, int high) {
        int pivot = dataArr[high];
        int less = low;
        int great = low;
        for(;great <= high - 1;great++){
            if(dataArr[great] < pivot){
                swap1(dataArr, less , great);
                less++;
            }
        }
        swap1(dataArr, less, high);
        return less;
    }
}
