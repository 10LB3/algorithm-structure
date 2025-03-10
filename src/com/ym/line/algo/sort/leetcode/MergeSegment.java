package com.ym.line.algo.sort.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSegment {
    public int[][] segment(int[][] intervals){
        // 1.按照区间左边的值进行升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 2.初始化output,动态数组用于存储结果
        ArrayList<int[]> output = new ArrayList<>();
        // 3.遍历每一个区间
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(output.isEmpty()){
                output.add(interval);
            }else{
                int[] lastInterval = output.get(output.size() - 1);
                int outputRight = lastInterval[1];
                int currLeft = interval[0];
                if(outputRight < currLeft){ // 没有重叠
                    output.add(interval);
                }else{
                   int currRight = interval[1];
                   lastInterval[1] = Math.max(outputRight, currRight);
                }
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
}
