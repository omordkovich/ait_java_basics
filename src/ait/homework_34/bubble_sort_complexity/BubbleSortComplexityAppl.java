package ait.homework_34.bubble_sort_complexity;
/*
Задача 1. Дополните метод bubbleSort счетчиком, который позволяет узнать, сколько операций было выполнено по ходу сортировки.
Выполните сортировку элементов массивов, в которых содержатся 10, 100 и 1000 элементов. Массивы заполните случайными целыми
числами в интервале от 0 до 1000. Как растет количество операций при сортировке при росте количества элементов массива?
 */

import java.util.Arrays;
import java.util.Random;

public class BubbleSortComplexityAppl {
    public static void main(String[] args) {
        int[] arrTen = new int[10];
        int[] arrHundred = new int[100];
        int[] arrThousand = new int[1000];
        Random random = new Random();

        fillArray(arrTen, random);
        System.out.println(Arrays.toString(arrTen));
        System.out.println("There are " + bubbleSortComplexity(arrTen) + " steps needed for bubble sort within array of " + arrTen.length + " elements");


        fillArray(arrHundred, random);
        System.out.println(Arrays.toString(arrHundred));
        System.out.println("There are " + bubbleSortComplexity(arrHundred) + " steps needed for bubble sort within array of " + arrHundred.length + " elements");


        fillArray(arrThousand, random);
        System.out.println(Arrays.toString(arrThousand));
        System.out.println("There are " + bubbleSortComplexity(arrThousand) + " steps needed for bubble sort within array of " + arrThousand.length + " elements");
        System.out.println("Every next cycle gets count of steps multiplied by 100. It is quadratic complexity O(n²)");
    }


    private static void fillArray(int[] arr, Random random) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
    }

    private static int bubbleSortComplexity(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }
        return count;
    }
}
