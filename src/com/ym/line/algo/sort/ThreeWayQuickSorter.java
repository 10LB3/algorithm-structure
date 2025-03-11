package com.ym.line.algo.sort;

import java.util.Arrays;

/**
 * 三路快排
 * 五个指针, i, low, high, less, great
 * 【i用来遍历整个数组区间, 取pivot = nums[great], 如果nums[i] < pivot, 则
 * less和i对应元素交换,less++,i++;
 * 如果nums[i] > pivot,则nums[i]与nums[great]交换, great--;(i不动)
 * 如果nums[i] == pivot,则i++
 * 】
 * ====》》 i > great, 则表明所有数据都处理完成了
 * [low, less) 存放小于分区点的元素
 * [less, i) 存放等于分区点的元素
 * [i,great) 未处理的元素
 * [great, high) 大于分区点的元素
 */
public class ThreeWayQuickSorter extends Sorter{
    public void quickSort(int[] data){
        if(data == null || data.length <= 1) return;
        sort2(data, 0 , data.length - 1);
    }
    // 一个新的类，用来返回需要的值
    public class PartitionSegment{
        public int less;
        public int great;

        public PartitionSegment(int less, int great) {
            this.less = less;
            this.great = great;
        }
    }

    /****方法一****/
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
    /****方式二****/
    private void sort2(int[] data, int low, int high) {
        if(low >= high) return;
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
        sort2(data, low, less - 1);
        sort2(data, great + 1, high);
    }
    public static void main(String[] args) {
        int[] data = new int[]{1,3,4,3,6,89,34,67,23,56,7,9,0,231,9,5};
//        new ShellSorter().shellSorter(data);
        new ThreeWayQuickSorter().quickSort(data);
        System.out.println(Arrays.toString(data));
    }
}
