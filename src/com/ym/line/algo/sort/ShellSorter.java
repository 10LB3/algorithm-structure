package com.ym.line.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class ShellSorter extends Sorter{
    public void isEmpty(int[] data){
        if(data == null || data.length <= 1) return;
    }
    public void shellSorter(int[] data){
        isEmpty(data);
        // 1.计算递增序列,不知道具体容量，所以需要动态数组
        int n = data.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int k = 1;
        int h;
        do{
            h = ((int)Math.pow(3,k) - 1) / 2;
            if(h > n / 3) break;
            arrayList.add(h);
            k++;
        }while (h <= n / 3);

        // 2.希尔排序
        for (k = arrayList.size() - 1; k >= 0 ; k--) { // 倒序遍历
            h = arrayList.get(k);
            // 将数组h变为有序
            for (int i = h; i < n; i++) {
                // 要比较j和j - 1,j - 1不能小于0，所以不能取0
                for (int j = i; j >= h; j -= h) {
                    if(data[j] < data[j - h]){
                        swap(data, j, j - h);
                    }else{
                        break;
                    }
                }
            }
        }
    }

    public void shellSorter1(int[] data){
        isEmpty(data);
        // 1.计算递增序列,不知道具体容量，所以需要动态数组
        int n = data.length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int k = 1;
        int h;
        do{
            h = ((int)Math.pow(3,k) - 1) / 2;
            if(h > n / 3) break;
            arrayList.add(h);
            k++;
        }while (h <= n / 3);

        // 2.希尔排序
        for (k = arrayList.size() - 1; k >= 0 ; k--) { // 倒序遍历
            h = arrayList.get(k);
            // 将数组h变为有序
            for (int i = h; i < n; i++) {
                int temp = data[i];
                int j;
                // 要比较j和j - 1,j - 1不能小于0，所以不能取0
                for (j = i; j >= h; j -= h) {
                    if(temp < data[j - h]){
                        data[j] = data[j - h];
                    }else{
                        break;
                    }
                }
                data[j] = temp;
            }
        }
    }

    public void shellSorter2(int[] data){
        if(data == null || data.length <= 1) return;
        // 1.计算递增序列,不知道具体容量，所以需要动态数组
        int n = data.length;
        int h = 1;
        while(h < n / 3) h = h * 3 + 1;

        // 2.希尔排序
        while(h >= 1){ // 倒序遍历
            for (int i = h; i < n; i++) {
                // 要比较j和j - 1,j - 1不能小于0，所以不能取0
                for (int j = i; j >= h; j -= h) {
                    if(data[j] < data[j - h]){
                        swap(data, j, j - h);
                    }else{
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,3,4,3,6,89,34,67,23,56,7,9,0,231,9,5};
//        new ShellSorter().shellSorter(data);
        new ShellSorter().shellSorter2(data);
        System.out.println(Arrays.toString(data));
    }
}
