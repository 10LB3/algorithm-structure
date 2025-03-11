package com.ym.line.algo.sort;

import java.util.Arrays;

/**
 * 计数排序: 考虑正数和负数 (特殊的桶排序,只是在桶里面计算个数)
 */
public class CountingSorter {
    public void sort(int[] nums){
        if(nums == null || nums.length <= 1) return;
        // 1.找到数组中最大的元素和最小的元素
        /**
         * 存在min的话所有的值，在count里面的指针j都需要减去min
         */
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        // 初始化count, 索引表示nums里面对应的元素值, count中的元素值表示出现的次数
        int[] count = new int[max - min + 1];
        // 2.计数
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }
//        System.out.println(Arrays.toString(count));
        // 3.计数累加
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        // 4.计算每个元素在排序数组中的位置
        int[] output = new int[nums.length];
        /**
         * 1.定义一个i指针, 从nums最后一个元素开始
         * 2.在count中定义一个j指针, 根据nums[i]找到下标，取出对应的count[j](里面存储的是Output里面的位置信息)
         * 3.k指针是在Output里面的,赋值之后，需要将count[j]--
          */
        for (int i = nums.length - 1; i >= 0 ; i--) {
            int j = nums[i];
            int k = count[j - min] - 1;
            output[k] = nums[i];
            count[j - min]--;
        }
        // 5.拷贝数组
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
