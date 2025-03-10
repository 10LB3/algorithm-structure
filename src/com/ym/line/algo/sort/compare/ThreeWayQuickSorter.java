package com.ym.line.algo.sort.compare;

import com.ym.line.algo.sort.Sorter;

import java.util.Arrays;

public class ThreeWayQuickSorter<E extends Comparable<E>> extends Sorter {
    public class PartitionSegment{
        public int less;
        public int great;

        public PartitionSegment(int less, int great) {
            this.less = less;
            this.great = great;
        }
    }
    public void quickSort(E[] data){
        if(data == null || data.length <= 1) return;
        sort(data, 0 , data.length - 1);
    }
    private void sort(E[] data, int low, int high){
        if(low >= high) return;
        PartitionSegment partitionSegment = partition(data, low, high);
        sort(data, low, partitionSegment.less - 1);
        sort(data, partitionSegment.great + 1, high);
    }
    private PartitionSegment partition(E[] data, int low, int high) {
        E pivot = data[high];
        int less = low;
        int great = high;
        int i = low;
        while (i <= great){
            if(data[i].compareTo(pivot) < 0){
                swap3(data, i, less);
                less++;
                i++;
            } else if (data[i].compareTo(pivot) > 0) {
                swap3(data, i, great);
                great--;
            }else{
                i++;
            }
        }
        return new PartitionSegment(less,great);
    }

    public static void main(String[] args) {
        Person person1 = new Person("raccoon", 10);
        Person person2 = new Person("copilot", 67);
        Person person3 = new Person("segment", 19);
        Person person4 = new Person("structure", 16);
//        new ShellSorter().shellSorter(data);
        Person[] people = new Person[]{person1, person2, person3, person4};
        new ThreeWayQuickSorter<Person>().quickSort(people);
        System.out.println(Arrays.toString(people));
    }
}
