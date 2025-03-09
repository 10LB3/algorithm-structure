package com.ym.line.algo.twoPoint;

public class RemoveZeros {
    public int[] moveZeros(int[] nums){
        if(nums == null) return new int[0];
        int n = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < n){
            if(nums[fast] != 0){
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length,fast=0,slow=0;
        while(fast<n){
            if(nums[fast]!=0){
                swap(nums,slow,fast);
                slow++;
            }
            fast++;
        }
    }

    public void swap(int[] nums,int slow,int fast){
        int temp = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = temp;
    }
}
