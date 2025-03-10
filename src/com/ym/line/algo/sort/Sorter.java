package com.ym.line.algo.sort;

public class Sorter {
    public <T> void swap3(T[] nums, int i, int j){
        T temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void swap1(Integer[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
