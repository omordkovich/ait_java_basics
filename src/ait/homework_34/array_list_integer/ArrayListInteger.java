package ait.homework_34.array_list_integer;
//Задача 4.(*)

import java.util.ArrayList;
import java.util.Random;

public class ArrayListInteger {
    public static void main(String[] args) {
        // Заполните структуру типа ArrayList 20-ю случайными целыми числами в интервале от 1 до 10.
        Random random = new Random();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            integerArrayList.add(random.nextInt(10) + 1);
        }
        System.out.println("Original array random (1-10): ");
        System.out.println(integerArrayList);
        // Удалите из полученного списка дубликаты.
        int length = integerArrayList.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (integerArrayList.get(j).equals(integerArrayList.get(i)) && i != j) {
                    integerArrayList.remove(j);
                    length--;
                    j = 0;
                }
            }
        }
        System.out.println("Remove doubles:");
        System.out.println(integerArrayList);
    }
}