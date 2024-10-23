package ait.homework_46.memory.utils;

//Задача 1. В классе MemoryService реализовать метод getMaxAvailableMemory, определяющий размер максимально
//возможного к созданию массива целых чисел. Проверяем решение через готовый тест.
public class MemoryService {
    public static int getMaxAvailableMemory() {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int maxSize = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2; //calculating the middle between low an high
            try {
                int[] testArray = new int[mid];
                maxSize = mid;
                low = mid + 1;
            } catch (OutOfMemoryError e) {
                return  maxSize - 1;
            }
        }
        return 0;
    }
}
