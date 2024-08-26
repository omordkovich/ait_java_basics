package ait.homework_30.code.memory.utils;

public class MemoryService {
    public static int getMaxAvailableMemory() {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int max = 0;
        boolean flag = true;
        while (flag) {
            int mid = left + (right - left) / 2;
            try {
                int[] array = new int[mid];
                max = mid;
                left = mid + 1;
            } catch (OutOfMemoryError e) {
                flag = false;
            }
        }
        return max;
    }
}
