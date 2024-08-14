package ait.homework_27.odd_even_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class OddEvenComparatorAppl {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        Comparator<Integer> oddEvenComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 % 2 != 0) ? 1 : (o2 % 2 != 0) ? -1 : o1.compareTo(o2);
            }
        };
        fillArray(array);
        System.out.println("Source array:");
        printArray(array);
        Arrays.sort(array, oddEvenComparator);
        System.out.println("Sorted: first even (sorted) then odd (unsorted):");
        printArray(array);

    }

    private static void fillArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (100 - 1) + 1);
        }
    }

    private static void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}