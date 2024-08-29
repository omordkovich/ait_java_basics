package ait.consultation_14.coins.model;

public class CoinAppl {
    public static void main(String[] args) {
        Coin[] table = new Coin[10];

        for (int i = 0; i < table.length; i++) {
            table[i] = new Coin();
        }
        printTable(table);
        System.out.println("\nThe lowest count of turns is " + lowestSteps(table));
    }

    private static <T> void printTable(T[] array) {
        for (T t : array) {
            System.out.print(t + " | ");
        }
    }

    private static int lowestSteps(Coin[] array) {
        int res = 0;
        int heads = 0;
        int tails = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].side.equals("head")) {
                heads++;
            } else {
                tails++;
            }
        }
        if (heads <= tails) {
            res = heads;
        } else {
            res = tails;
        }
        return res;
    }
}
