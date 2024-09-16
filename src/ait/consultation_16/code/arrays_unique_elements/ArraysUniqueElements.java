package ait.consultation_16.code.arrays_unique_elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Задача 2. (*) Даны два списка неуникальных целых чисел или слов. Посчитайте,
сколько уникальных элементов содержится одновременно, как в первом, так и во втором списке.
 */
public class ArraysUniqueElements {
    public static void main(String[] args) {
        //creating list of non-unique integers
        List<Integer> intArray = new ArrayList<>(Arrays.asList(1, 4, 5, 7, -5, 1, 2, 7, 1, 2, 23, 35, 0, 0));
        System.out.println(intArray.toString());
        System.out.printf("number of unique elements is: %d", countUnique(intArray));
        System.out.println();
        //creating list of non-unique strings
        List<String> strArray = new LinkedList<>(Arrays.asList("one", "two", "three", "four", "one", "one", "three"));
        System.out.println(strArray.toString());
        System.out.printf("number of unique elements is: %d", countUnique(strArray));
        System.out.println();
        System.out.printf("number of unique elements in both lists is: %d", countMultiUnique(intArray, strArray));
    }

    //method counts number of unique elements in 2 lists
    public static <I, S> int countMultiUnique(List<I> array1, List<S> array2) {
        return countUnique(array1) + countUnique(array2);
    }

    //method counts number of unique elements in list
    public static <T> int countUnique(List<T> array) {
        int count = 0;  //setting count
        for (int i = 0; i < array.size(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < array.size(); j++) {
                if (array.get(i).equals(array.get(j)) && i != j) { //if twin is found-break the inner loop
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                count++; // counts up if no twin was found
            }
        }
        return count;
    }
}
