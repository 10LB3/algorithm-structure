package com.ym.line.algo.sort;

import com.ym.line.algo.sort.compare.Person;

import java.util.Arrays;
import java.util.Comparator;

public class JavaSorter {
    public static void main(String[] args) {
        int[] data = new int[]{10, 3, 5, 7, 9, 8, 20};
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));

        Person person1 = new Person("raccoon", 10);
        Person person2 = new Person("copilot", 67);
        Person person3 = new Person("segment", 19);
        Person person4 = new Person("structure", 16);
//        new ShellSorter().shellSorter(data);
        Person[] people = new Person[]{person1, person2, person3, person4};
        Comparator<Person> comparator = (o1, o2) -> o1.getAge() - o2.getAge();
        Arrays.sort(people, comparator);
        System.out.println(Arrays.toString(people));
    }

}
