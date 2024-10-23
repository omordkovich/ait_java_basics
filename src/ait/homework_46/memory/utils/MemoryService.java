package ait.homework_46.memory.utils;

//Задача 1. В классе MemoryService реализовать метод getMaxAvailableMemory, определяющий размер максимально
//возможного к созданию массива целых чисел. Проверяем решение через готовый тест.
public class MemoryService {
    public static int getMaxAvailableMemory() {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int max = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2; //calculating the middle between low and high
            try {
                int[] arr = new int[mid];
                max = mid;
                low = mid + 1;
            } catch (OutOfMemoryError e) {
                return  max - 1;
            }
        }
        return 0;
    }
}
