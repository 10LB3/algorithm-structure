package com.ym.line.algo.sort;

import java.util.Arrays;

public class RadixSorter {
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        // 1.找到最大值
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(nums, exp);
        }
    }
    private void countingSort(int[] nums, int exp){
        // 之所以为10，是因为数字只有0-9十个数字
        int[] count = new int[10];
        for (int i = 0; i < nums.length; i++) {
            int digit = (nums[i] / exp) % 10;
            count[digit]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int digit = (nums[i] / exp) % 10;
            int k = count[digit] - 1;
            output[k] = nums[i];
            count[digit]--;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] data = new int[]{4512, 4321,9876,5643, 31924};
        new RadixSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
