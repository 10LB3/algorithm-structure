package com.ym.line.algo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSorter extends Sorter{
    public void sort(int[] nums){
        if(nums == null || nums.length <= 1){
            return;
        }
        int n = nums.length;
        // 有多少元素就排多少轮
        for (int round = 1; round <= nums.length; round++) {
            int compareTimes = n - round;
            // 控制每轮比较次数
            for (int i = 0; i < compareTimes; i++) {
                if(nums[i] > nums[i + 1]){
                    swap(nums, i, i + 1);
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{10, 20, 3, 5, 7};
        System.out.println(data);
        System.out.println("==========");
        new BubbleSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
