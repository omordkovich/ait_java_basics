package ait.homework_46.memory.test;

import ait.homework_46.memory.utils.MemoryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemoryServiceTest {

    int[] arr;

    @Test
    void test() {
        int maxMemory = MemoryService.getMaxAvailableMemory();
        boolean flag;
        try {
            arr = new int[maxMemory];
            flag = true;
        } catch (OutOfMemoryError e) {
            flag = false;
        }
        assertTrue(flag);
        try {
            arr = new int[maxMemory + 1];
            flag = true;
        } catch (OutOfMemoryError e) {
            flag = false;
        }
        assertFalse(flag);
    }
}
