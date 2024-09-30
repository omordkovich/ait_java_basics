package ait.homework_40;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
Задача 3(*). В классе DigitsFreqApp сгенерировать один миллион положительных целых чисел
в интервале от 100 до 1000, и подсчитать частоту встречаемости цифр в этих числах.
 */
public class DigitsFreqAppl {
    public static void main(String[] args) {
        Random random = new Random();
        //create array with random numbers 100-1000
        Integer[] digits = new Integer[1000000];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = random.nextInt(99, 1000) + 1;
        }
        //create hash map with digit(key) and frequency (value)
        Map<Integer, Integer> digitFrequency = new HashMap<>();
        for (Integer i : digits) {
            if (!digitFrequency.containsKey(i)) {
                digitFrequency.put(i, 1);
            } else {
                digitFrequency.put(i, digitFrequency.get(i) + 1);
            }
        }
        //print hash map
        for (Integer i : digitFrequency.keySet()) {
            System.out.println("Number: " + i + " Frequency: " + digitFrequency.get(i));
        }
    }
}
