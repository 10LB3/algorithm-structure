package com.ym.line.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSorter {
    public void sort(int[] data){
        if(data == null || data.length <= 1) return;
        // 1.创建几个空的bucket
        int maxValue = data[0];
        for(int d: data){
            maxValue = Math.max(maxValue, d);
        }
        int bucketNum = maxValue / 10 + 1;
        // 2.动态数组表示桶的大小
        ArrayList<Integer>[] buckets = new ArrayList[bucketNum];
        // 3.将所有元素添加进对应的bucket
        for (int i = 0; i < data.length; i++) {
            // 计算当前元素应该被分配到哪一个桶中
            int index = data[i] / 10;
            if(buckets[index] == null){
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(data[i]);
        }
        // 4.对每一个bucket的元素进行排序
        for (int i = 0; i < bucketNum; i++) {
            ArrayList<Integer> bucketData = buckets[i];
            if(bucketData != null){
                new IntegerArrayQuickSort().quickSort(bucketData);
            }
        }
        // 5.从buckets里面拿到排序后的数组
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            ArrayList<Integer> bucketData = buckets[i];
            for (int j = 0; j < bucketData.size(); j++) {
                data[index++] = bucketData.get(j);
            }
        }
    }
    public static void main(String[] args) {
        int[] data = new int[]{10, 20, 3, 5, 7, 9, 56, 8};
        new MergeSorter().sortBU(data);
        System.out.println(Arrays.toString(data));
    }
}
