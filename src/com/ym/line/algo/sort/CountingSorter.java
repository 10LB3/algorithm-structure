package com.ym.line.algo.sort;

import java.util.Arrays;

/**
 * 计数排序: 考虑
 */
public class CountingSorter {
    public void sort(int[] nums){
        if(nums == null || nums.length <= 1) return;
        // 1.找到数组中最大的元素
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
//        // 2.找到元素的最小值
//        int min = nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            min = Math.min(min, nums[i]);
//        }
        // 3.初始化count
        int[] count = new int[max - min + 1];
        // 4.计数
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }
//        System.out.println(Arrays.toString(count));
        // 5.计数累加
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // 6.计算每个元素在排序数组中的位置
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0 ; i--) {
            int j = nums[i];
            int k = count[j - min] - 1;
            output[k] = nums[i];
            count[j - min]--;
        }
        // 7.拷贝数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{10, 3, 5, 7, 9, 8, 20};
        new CountingSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }

}
