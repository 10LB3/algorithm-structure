package com.ym.line.algo.sort.leetcode;

import com.ym.line.algo.sort.RadixSorter;

import java.util.Arrays;

public class _164_MaximumGap {
    /****基数排序****/
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        new RadixSorter().sort(nums); // 时间复杂度O(n) 空间复杂度满足
        int maxGap = nums[0] - nums[1];
        for (int i = 2; i < nums.length; i++) {
            maxGap = Math.max(maxGap,nums[i] - nums[i - 1]);
        }
        return maxGap;
    }
    /****内置函数排序****/
    public int maximumGap1(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        Arrays.sort(nums); // 时间复杂度O(nlogn) 空间复杂度满足
        int maxGap = nums[0] - nums[1];
        for (int i = 2; i < nums.length; i++) {
            maxGap = Math.max(maxGap,nums[i] - nums[i - 1]);
        }
        return maxGap;
    }
    /****桶排序****/
    /**
     * 解决问题一:桶的个数, bucketNum = nums.length
     * 解决问题二:每个元素放在那个桶中, bucketId = (num - min) / gap
     * @param nums
     * @return
     */
    public int maximumGap2(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        for(int num:nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if(max == min) return 0;
        int gap = (int)Math.ceil((double) (max - min) / (nums.length - 1));
        // 2.初始化桶的数组
        int bucketNum = nums.length;
        Bucket[] buckets = new Bucket[bucketNum];
        // 对每个桶都要初始化
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }
        // 3.将所有元素都放入桶中
        for(int num:nums){
            int bucketId = (num - min) / gap;
            buckets[bucketId].hasData = true;
            buckets[bucketId].min = Math.min(buckets[bucketId].min, num);
            buckets[bucketId].max = Math.max(buckets[bucketId].max, num);
        }
        // 4.计算最大间隔
        int maxGap = 0;
        int prevBucketMax = min;
        for(Bucket bucket: buckets){
            if(!bucket.hasData) continue;
            maxGap = Math.max(maxGap, bucket.min - prevBucketMax);
            prevBucketMax = bucket.max;
        }
        return maxGap;
    }
    public class Bucket{
        public boolean hasData = false;
        public int min = Integer.MAX_VALUE;
        public int max = Integer.MIN_VALUE;
    }
}
