package com.ym.line.algo.sort;

import java.util.Arrays;

public class MergeSorter {
    public void sort(int[] data){
        if(data == null || data.length <= 1) return;
        int[] temp = new int[data.length];
        sort1(data,0, data.length - 1, temp); // 大问题
    }
    // 给子数组进行排序，子问题
    private void sort1(int[] data, int left, int right, int[] temp){
        if(left == right) return;
        int mid = left + (right - left) / 2;
        sort1(data, left, mid, temp);
        sort1(data,mid + 1, right, temp);
        merge2(data, left, mid, right, temp);
    }
    /****方法一****/
    private void merge(int[] data, int left, int mid, int right, int[] temp) {
        int tempPos = left;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <=right){
            if(data[i] <= data[j]){
                temp[tempPos++] = data[i++];
            }else {
                temp[tempPos++] = data[j++];
            }
        }
        while(i <= mid){
            temp[tempPos++] = data[i++];
        }

        while (j <= right){
            temp[tempPos++] = data[j++];
        }
        // 拷贝的过程
        for(tempPos = left;tempPos <= right;tempPos++){
            data[left++] = temp[tempPos];
        }
    }
    /****方法二****/
    private void merge2(int[] data, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = data[i];
        }
        int i = left;
        int j = mid + 1;
        for(int k = left;k<=right;k++){
            if(i == mid + 1){  //左边没有元素，右边有元素
                data[k] = temp[j++];
            } else if (j == right + 1) {
                data[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                data[k] = temp[i++];
            }else{
                data[k] = temp[j++];
            }
        }
        
    }
    public void sortBU(int[] data){
        if(data == null || data.length <= 1) return;
        int len = data.length;
        int[] temp = new int[len];
        for(int size = 1;size < len;size += size){ // size表示字符组的长度
            for (int left = 0; left < len - size; left += 2*size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size- 1,len - 1);
                merge(data,left,mid,right,temp);
            }
        }
    }
    public static void main(String[] args) {
        int[] data = new int[]{10, 20, 3, 5, 7, 9, 56, 8};
        new MergeSorter().sortBU(data);
        System.out.println(Arrays.toString(data));
    }

}
