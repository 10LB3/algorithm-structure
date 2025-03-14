package com.ym.line.algo.bs;

public class BasicBinarySearch {
    public boolean contains(int[] nums, int target){
        if(nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            else if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
