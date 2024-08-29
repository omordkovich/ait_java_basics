package ait.consultation_14.coins;

import java.util.Random;

/*
На столе лежат n монеток. Некоторые из них лежат вверх решкой, а некоторые – гербом. Определите минимальное число монеток,
которые нужно перевернуть, чтобы все монетки были повернуты вверх одной и той же стороной.
 */
public class Coins {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 100;
        int[] coins = new int[n];
        fillArray(coins,random);
        System.out.println("The lowest count of turns is " + lowestSteps(coins));
    }

    public static void fillArray(int[] array, Random random) {
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(2);
        }
    }

    public static int lowestSteps(int[] array) {
        int res = 0;
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeros++;
            } else {
                ones++;
            }
        }
        if (zeros >= ones) {
            res = zeros;
        } else {
            res = ones;
        }
        return res;
    }
}
