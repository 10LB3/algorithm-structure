package com.ym.line.algo.sort;

import java.util.Arrays;

public class InsertionSorter extends Sorter{
    public void sort(int[] nums){
        if (nums == null || nums.length <= 1) return;
        // 控制插入排序的轮数
        for (int i = 1; i < nums.length; i++) {
            // 要比较j和j - 1,j - 1不能小于0，所以不能取0
            for (int j = i; j > 0; j--) {
                if(nums[j] < nums[j - 1]){
                    swap(nums, j, j - 1);
                }else{
                    break;
                }
            }
        }
    }
    /****效率高****/
    public void sort2(int[] data){
        if (data == null || data.length <= 1) return;
        // 控制插入排序的轮数
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int j;
            // 要比较j和j - 1,j - 1不能小于0，所以不能取0
            for (j = i; j > 0; j--) {
                if(temp < data[j - 1]){
                    // 将较大的元素往后移动一位
                    data[j] = data[j - 1];
                }else{
                    break;
                }
            }
            // 找到元素i对应位置需要插入的地方
            data[j] = temp;
        }
    }
    public static void main(String[] args) {
        int[] data = new int[]{10, 20, 3, 5, 7, 8};
        System.out.println(data);
        System.out.println("==========");
        new InsertionSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
