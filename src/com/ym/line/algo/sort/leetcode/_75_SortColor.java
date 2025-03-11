package com.ym.line.algo.sort.leetcode;

/**
 * 计数排序:只有三个元素，非常快速
 */
public class _75_SortColor {
    public void sortColors(int[] nums){
        // 1.计数
        int[] count = new int[3];
        for (int num:nums){
            count[num]++;
        }
        // 2.排序
        int k = 0;
        for (int i = 0; i < 3; i++) {
            int num = count[i];
            for (int j = 0; j < num; j++) {
                nums[k++] = i;
            }
        }
    }
    /****三路快排****/
    public void sortColors1(int[] nums){
        int zero = 0;
        int two = nums.length - 1;
        int i = 0;
        while (i <= two){
            if(nums[i] == 1){
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, two);
                two--;
            }else{
                i++;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
