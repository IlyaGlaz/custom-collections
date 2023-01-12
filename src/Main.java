import collections.MyArrayList;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(10);
        Stream.iterate(0, i -> i + 1)
                .limit(10)
                .forEach(list::add);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("--------------------");

        list.remove(8);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        MyArrayList<Integer> list2 = new MyArrayList<>(10);
        Stream.iterate(100, i -> i + 1)
                .limit(20)
                .forEach(list::add);

        list.addAll(list2);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        int[] numbers = new int[20];

        for (int i = numbers.length - 1; i > 0; i--) {
            numbers[i] = i;
        }

        MyArrayList.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}