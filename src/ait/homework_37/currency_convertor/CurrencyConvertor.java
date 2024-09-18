package ait.homework_37.currency_convertor;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CurrencyConvertor {
    public static void main(String[] args) {
        Currency[] currencies = Currency.values();
        Set<Currency> uCurrencies = new LinkedHashSet<>();
        for (Currency c : currencies) {
            uCurrencies.add(c);
        }
        printCurrencies(uCurrencies);
        Scanner scanner = new Scanner(System.in);
        double quantity = 0;
        double rate = 0;
        boolean flag;
        do {
            flag = false;
            System.out.print("Input number of currency: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> rate = Currency.EUR.getRate();
                case "2" -> rate = Currency.USD.getRate();
                case "3" -> rate = Currency.CHF.getRate();
                case "4" -> rate = Currency.GBP.getRate();
                default -> {
                    System.out.println("Wrong input!");
                    flag = true;
                }
            }
        } while (flag);
        do {
            System.out.print("Input amount of money: ");
            String amount = scanner.nextLine();
            try {
                quantity = Double.parseDouble(amount);
                flag = true;
            } catch (NumberFormatException n) {
                System.out.println("Wrong Input!");
            }
        } while (!flag);
        double res = quantity / rate;
        System.out.printf("You get: %.2f", res);
        System.out.println(" euro");
    }

    private static <E> void printCurrencies(Set<E> currencies) {
        for (E e : currencies) {
            System.out.println(e);
        }
        System.out.println("-----------------------------");
    }
}
