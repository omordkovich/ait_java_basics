package ait.homework_37.hash_set_metods;

import java.util.*;

/*
Задача 2. Написать программу, которая:
прочитает с клавиатуры количество чисел в коллекции (сколько будет чисел в коллекции),
заполнит коллекцию случайными числами в интервале от 1 до 100,
переносим коллекцию во множество (set);
удалить из множества числа большие 10 и вывести полученные результаты на экран. Все числа целые.
 */
public class HashSetMetods {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter count of numbers in collection: ");
        boolean flag = true;
        int size = 0;
        do {
            try {
                String input = scanner.nextLine();
                size = Integer.parseInt(input);
                flag = false;
            } catch (NumberFormatException n) {
                System.out.println("Wrong input! Try again!");
            }
        } while (flag);
        List<Integer> list = new ArrayList<>();
        fillCollection(list, size);
        printList(list);
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer i : list) {
            uniqueNumbers.add(i);
        }
        uniqueNumbers.removeIf(n -> n > 10);
        printList(uniqueNumbers);

    }

    private static void fillCollection(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(1, 101));
        }
    }

    private static void printList(Collection<Integer> collection) {
        for (Integer i : collection) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("======================================");
    }


}
