package ait.homework_27.odd_even_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class OddEvenComparatorAppl {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (100 - 1) + 1);
        }

        Comparator<Integer> oddEvenComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if ((o1 % 2 != 0 && o2 % 2 != 0)||(o1 % 2 == 0 && o2 % 2 == 0) ) {
                    return o1.compareTo(o2);
                }
                if (o1 % 2 == 0) {
                    return -1;
                }
                return 1;
            }
        };
        printArray(array);
        Arrays.sort(array,oddEvenComparator);
        printArray(array);

    }

    private static void printArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
        System.out.println();
    }
}
