package com.ym.line.algo.sort.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _179_largestNumber {
    public String largestNumber(int[] nums){
        // 1.将所有元素转换成字符串
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return yx.compareTo(xy);
            }
        });
        /****方法二****/
        sort2(nums, 0, nums.length - 1);
        if(nums[0] == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for(int num: nums){
            sb.append(num);
        }
        return sb.toString();
    }
    private void sort2(int[] data, int low, int high) {
        if(low >= high) return;
        int pivot = data[high];
        int less = low;
        int great = high;
        int i = low;
        while (i <= great){
            // 拼接组成字符串
            String xy = data[i] + "" + pivot;
            String yx = pivot + "" + data[i];
            // 如果x在前面比较大，需要将x往在前面
            if(xy.compareTo(yx) > 0){
                swap(data, i, less);
                less++;
                i++;
            } else if (xy.compareTo(yx) < 0) {
                // 往后扔x
                swap(data, i, great);
                great--;
            }else{
                i++;
            }
        }
        sort2(data, low, less - 1);
        sort2(data, great + 1, high);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
