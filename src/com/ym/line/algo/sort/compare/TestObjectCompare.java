package com.ym.line.algo.sort.compare;

import java.util.Comparator;

public class TestObjectCompare {
    public static void main(String[] args) {
        Person person1 = new Person("raccoon", 10);
        Person person2 = new Person("copilot", 12);
//        int i = person1.compareTo(person2);
//        int i1 = person2.compareTo(person1);
//        System.out.println(i1);
//        PersonComparator personComparator = new PersonComparator();
//        int compare = personComparator.compare(person1, person2);
//        System.out.println(compare);
        // 匿名内部类
        Comparator<Person> comparator = (o1, o2) -> o1.getAge() - o2.getAge();
        int compare = comparator.compare(person1, person2);
        System.out.println(compare);
    }
}
class PersonComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge() < o2.getAge()){
            return -1;
        } else if (o1.getAge() > o2.getAge()) {
            return 1;
        }else {
            return 0;
        }
    }
}
