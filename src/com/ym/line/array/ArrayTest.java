package com.ym.line.array;

import com.ym.line.array.ArrayList;

public class ArrayTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(1);
//        arrayList.addLast(34);
        arrayList.add(0,23);
//        arrayList.addLast(12);
//        arrayList.addLast(121);
//        arrayList.addLast(2);
//        arrayList.addLast(42);
//        arrayList.addLast(62);
//        arrayList.addLast(72);
        System.out.println(arrayList);

//        arrayList.addLast(34);
//        System.out.println(arrayList);
//
//        arrayList.removeLast();
        arrayList.removeLast();
//        arrayList.addLast(1);
//        arrayList.remove(0);
//        arrayList.remove(0);
        System.out.println(arrayList);
        System.out.println(arrayList.getCapacity());
        arrayList.addLast(2);
        System.out.println(arrayList);



    }
}
