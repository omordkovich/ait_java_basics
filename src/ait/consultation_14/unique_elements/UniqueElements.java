package ait.consultation_14.unique_elements;

/*
Задача 3. Даны два списка неуникальных целых чисел или слов. Реализуйте метод, который возвращает сколько уникальных
 элементов содержится одновременно, как в первом, так и во втором списке.
 */
public class UniqueElements {
    public static void main(String[] args) {
        Integer[] intArray = {2, 5, 6, 4, 2, 3, 5, 2, 1, 4, 5, 2, 9, 7};
        String[] strArray = {"bla", "bla", "bla", "one", "two", "three", "one"};
        System.out.println("There are " + numberOfUnique(intArray) + " unique elements in Integer array.");
        System.out.println("There are " + numberOfUnique(strArray) + " unique elements in String array.");
    }

    public static <T> int numberOfUnique(T[] array) {
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            boolean found = false;
            for (int j = 0; j < array.length; j++) {
                if (array[i].equals(array[j]) && i != j) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                res++;
            }
        }
        return res;
    }
}
