package com.ym.line.array;

import com.ym.line.array.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList(10);
        System.out.println(arrayList.isEmpty());
        arrayList.addFirst(34);
        arrayList.addLast(64);
        arrayList.add(2,17);
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList);
        arrayList.remove(1);
        System.out.println(arrayList);
        arrayList.removeElement(34);
        System.out.println(arrayList);
        ArrayList<String> arrayList1 = new ArrayList<>(12);
        arrayList1.add(0, "helloWorld");
        arrayList1.addLast("doris");
        System.out.println(arrayList1);
    }
}
