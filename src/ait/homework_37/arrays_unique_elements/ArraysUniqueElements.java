package ait.homework_37.arrays_unique_elements;

import java.util.*;

/*Задача 4. (*) Даны два списка неуникальных целых чисел или слов. Посчитайте,
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

    //method counts number of unique elements in Lists
    public static <T> int countUnique(List<T> array) {
        Set<T> uElements = new HashSet<>();
        for (T t : array) {
            uElements.add(t);
        }
        return uElements.size();
    }

    //method counts number of unique elements in 2 lists
    public static <I, S> int countMultiUnique(List<I> array1, List<S> array2) {
        return countUnique(array1) + countUnique(array2);
    }
}
