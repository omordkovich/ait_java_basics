package ait.homework_38.unique_names;

import java.util.*;

/*
Задача 1. Создайте список из 20 имен людей с повторениями. Удалите из списка все повторяющиеся имена. Выведите список уникальных имен в алфавитном порядке.

Условия: Программа должна использовать HashSet для удаления дубликатов. Подсказка: Для сортировки уникальных слов можно использовать класс ArrayList и метод Collections.sort().
 */
public class UniqueNames {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Emily");
        names.add("Michael");
        names.add("Sarah");
        names.add("David");
        names.add("Jessica");
        names.add("James");
        names.add("Emma");
        names.add("John");
        names.add("Michael");
        names.add("Emily");
        names.add("David");
        names.add("Jessica");
        names.add("Sarah");
        names.add("Emma");
        names.add("James");
        names.add("Michael");
        names.add("Sarah");
        names.add("Emily");
        names.add("John");
        //copy to hash set to get a list of unique names
        Set<String> uniqueNames = new HashSet<>();
        for (String s : names) {
            uniqueNames.add(s);
        }
        //copy back to array list for sorting
        names.clear();
        for (String s : uniqueNames) {
            names.add(s);
        }
        Collections.sort(names);
        printArray(names);
    }

    private static <E> void printArray(List<E> list) {
        for (E e : list) {
            System.out.println(e);
        }
    }
}
